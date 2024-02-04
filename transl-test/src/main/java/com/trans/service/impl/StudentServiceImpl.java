package com.trans.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.sax.Excel03SaxReader;
import cn.hutool.poi.excel.sax.Excel07SaxReader;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trans.common.Constant;
import com.trans.config.DistrictCodeRowHandler;
import com.trans.entity.Student;
import com.trans.mapper.StudentMapper;
import com.trans.service.IDistrictCodeService;
import com.trans.service.IStudentService;
import com.trans.thread.ThreadTestConfig;
import com.trans.until.ChineseUntil;
import com.trans.until.CustomException;
import com.trans.until.ObsProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;


/**
 * @Author: ZouJiaJun
 * @Title: StudentServiceImpl
 * @Package: com.trans.service.impl
 * @Description:
 * @Date: 2022/7/25 - 11:37
 */

@Service
@Slf4j
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ObsProperties obsProperties;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private ExecutorService longLinkExecutor;

    @Autowired
    private IDistrictCodeService districtCodeServiceImpl;

    @Autowired
    private ThreadTestConfig threadConfig;

    @Override
    @Transactional
    public Student insertStudent(Integer id) {
        Student max = studentMapper.selectOne(Wrappers.lambdaQuery(Student.class)
                .orderByDesc(Student::getStuId)
                .last("limit 1"));

        Student student = new Student();
        student.setStuId(id < max.getStuId()? max.getStuId()+1:id);
        student.setAge(RandomUtil.randomInt(6,24));
        student.setClassId(2);
        student.setName(ChineseUntil.getRandomChineseName());
        this.save(student);

        makeError(id);

        Student studentA = new Student();
        studentA.setStuId(student.getStuId()+1);
        studentA.setAge(RandomUtil.randomInt(6,24));
        studentA.setClassId(2);
        studentA.setName(ChineseUntil.getRandomChineseName());
        this.save(studentA);
        return student;
    }

    public Student getStudent(Integer id) {
        Student max = studentMapper.selectOne(Wrappers.lambdaQuery(Student.class)
                .orderByDesc(Student::getStuId)
                .last("limit 1"));

        Student student = new Student();
        student.setStuId(id < max.getStuId()? max.getStuId()+1:id);
        student.setAge(RandomUtil.randomInt(6,24));
        student.setClassId(2);
        student.setName(ChineseUntil.getRandomChineseName());
        this.save(student);

        makeError(id);

        Student studentA = new Student();
        studentA.setStuId(student.getStuId()+1);
        studentA.setAge(RandomUtil.randomInt(6,24));
        studentA.setClassId(2);
        studentA.setName(ChineseUntil.getRandomChineseName());
        this.save(studentA);
        return student;
    }

    private void makeError( int b) {
        int a = 3;
        try {
            int c= a / b;
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public ObsProperties.OssSecret getObs() {
        ObsProperties.OssSecret huawei = obsProperties.getOss().get(ObsProperties.Type.HUAWEI);
        System.out.println(huawei);
        return huawei;
    }

    @Override
    public Student getFormRedis(String id) {
        String key = Constant.RedisConstant.STUDENT_KEY+id;
        Student student =(Student) redisTemplate.opsForValue().get(key);
        if(ObjectUtil.isEmpty(student)){
            student = studentMapper.selectById(id);
            redisTemplate.opsForValue().set(key,student);
        }
        return student;
    }

    @Override
    public Student updateName(Integer id) {
        Student student = studentMapper.selectById(id);
        if(ObjectUtil.isNotEmpty(student)){
            student.setName(ChineseUntil.getRandomChineseName());
            student.setSex("男");
            studentMapper.updateById(student);
            return student;
        }
        return null;
    }

    @Override
    public List<Student> selectByName(List<String> names) {

        List<Student> students = studentMapper.selectByName(names);
        return students;
    }

    @Override
    public Boolean testLongLink(String stuId) throws ExecutionException, InterruptedException {

        return longLinkExecutor.submit(() ->{
            return doIt(stuId);
        }).get();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void localHutool(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        log.info("文件名：{}",filename);
        ExcelUtil.readBySax(file.getInputStream(), 0, new DistrictCodeRowHandler(districtCodeServiceImpl));

    }

    @Override
    public void testMergeExcel(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        RowHandler rowHandler = new RowHandler() {

            @Override
            public void handle(int sheetIndex, long rowIndex, List<Object> rowCells) {
                log.info("sheetIndex:{},rowIndex:{},rowCells:{}",sheetIndex,rowIndex,rowCells);
            }
        };
        // 根据文件格式选择相应的SaxReader
        if (originalFilename.endsWith(".xlsx")) {
            Excel07SaxReader reader = new Excel07SaxReader(rowHandler);
            reader.read(file.getInputStream(), 0);
        } else if (originalFilename.endsWith(".xls")) {
            Excel03SaxReader reader = new Excel03SaxReader(rowHandler);
            reader.read(file.getInputStream(), 0);
        } else {
            System.out.println("Unsupported file format");
        }

    }

    @Override
    public List<Integer> seletListByName(List<String> names) {
        List<Integer> list = studentMapper.selectListByName(names);
        System.out.println(list);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean testThread() throws ExecutionException, InterruptedException {
        List<Integer> list = Arrays.asList(100, 101, 102, 103, 104);
        ThreadPoolTaskExecutor taskExecutor = threadConfig.textProcessExecutor();
        List<CompletableFuture<Student>> futures = new ArrayList<>();
        for (Integer a:list) {
            CompletableFuture<Student> future = CompletableFuture.supplyAsync(() -> {
                if(a == 103){
                    throw new CustomException("测试异常");
                }
                return getStudent(a);
            }, taskExecutor);
            futures.add(future);
        }
        ArrayList<Student> students = new ArrayList<>();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).get();
        for (CompletableFuture<Student> student:futures) {
            students.add(student.get());
        }
        System.out.println(students);
        return true;
    }

    private Boolean checkCondition(String stuId){
        Student student = studentMapper.selectById(stuId);
        if(ObjectUtil.isNotEmpty(student) && student.getName().equals("邹铭")){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Boolean doIt(String stuId){
        while (!checkCondition(stuId)){
            try {
                // 等待一段时间后再次检查条件
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return Boolean.TRUE;
    }

}
