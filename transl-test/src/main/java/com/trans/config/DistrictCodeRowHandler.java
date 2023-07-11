package com.trans.config;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import com.trans.entity.DistrictCode;
import com.trans.mapper.DistrictCodeMapper;
import com.trans.service.IDistrictCodeService;
import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZouJiaJun
 * @Title: DistrictCodeRowHandler
 * @Package: com.trans.config
 * @Description:
 * @Date: 2023/7/10 - 15:15
 */
public class DistrictCodeRowHandler implements RowHandler {

    private final int batchSize = 100;

    private  List<DistrictCode> districtCodes = new ArrayList<>();

    private IDistrictCodeService districtCodeServiceImpl;


    @Autowired
    public DistrictCodeRowHandler(IDistrictCodeService districtCodeServiceImpl){
        this.districtCodeServiceImpl = districtCodeServiceImpl;
    }

    public DistrictCodeRowHandler(){

    }


    @Override
    public void handle(int sheetIndex, long rowIndex, List<Object> rowCells) {
        if(rowIndex > 0 && CollectionUtil.isNotEmpty(rowCells)){
            Object[] objects = rowCells.toArray(new Object[0]);
            System.out.println(rowCells);
            buildEntity(objects);
            if(districtCodes.size() >= batchSize){
                districtCodeServiceImpl.saveBatch(districtCodes);
                districtCodes.clear();
            }
        }
    }


    @Override
    public void doAfterAllAnalysed() {
        if(CollectionUtil.isNotEmpty(districtCodes)){
            districtCodeServiceImpl.saveBatch(districtCodes);
        }
    }


    void buildEntity(Object[] rowData){
        if(rowData[0] != null && StrUtil.isNotBlank(rowData[0].toString())){
            DistrictCode districtCode = new DistrictCode();
            districtCode.setProvinceName(rowData[0].toString());
            districtCode.setProvinceCode(rowData[1].toString());
            districtCode.setCityName(rowData[2].toString());
            districtCode.setCityCode(rowData[3].toString());
            districtCode.setCountryside(rowData[4].toString());
            districtCode.setCountrysideCode(rowData[5].toString());
            districtCodes.add(districtCode);
        }
    }
}
