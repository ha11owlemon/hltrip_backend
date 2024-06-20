package com.hall.Controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellExtra;
import com.hall.Bean.*;
import com.hall.DAO.CommentsMapper;
import com.hall.DAO.HouseOverviewMapper;
import com.hall.DAO.LandlordsMapper;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Controller
public class testController {

    @Resource
    HouseOverviewMapper houseOverviewMapper;

    @Resource
    LandlordsMapper landlordsMapper;

    @Resource
    CommentsMapper commentsMapper;


    @GetMapping("/test")
    @ResponseBody
    public Map<String,String> test(){
        System.out.println("11111111111111111111111111");
        HashMap<String, String> map = new HashMap<>();
        map.put("key","value");
        return map;
    }

//    @PostMapping("/test1")
//    @ResponseBody
//    public String test2() throws IOException {
//        String fileName = "D:\\BaiduNetdiskDownload\\data.xlsx"; // Excel 文件的路径
//
//        // 定义数据存储容器
//        List<Map<Integer, String>> dataList = new ArrayList<>();
//        // 构造监听器对象
//        AnalysisEventListener<Map<Integer, String>> listener = new AnalysisEventListener<Map<Integer, String>>() {
//            @Override
//            public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
//                dataList.add(rowData); // 将每行数据添加到容器中
//            }
//
//            @Override
//            public void extra(CellExtra extra, AnalysisContext context) {
//                // 处理额外的单元格信息，比如合并单元格、批注等
//                // ...
//            }
//
//            @Override
//            public void doAfterAllAnalysed(AnalysisContext context) {
//                // 数据解析完成后的操作，可以在这里进行业务逻辑处理
//                // ...
//            }
//        };
//
//        // 读取 Excel 文件
//        EasyExcel.read(fileName).registerReadListener(listener).sheet(0).doRead();
//        ArrayList<String> comments = new ArrayList<>();
//        // 遍历数据
//        for (Map<Integer, String> rowData : dataList) {
//            // 处理每行数据
//            for (Map.Entry<Integer, String> entry : rowData.entrySet()) {
//                //Integer columnIndex = entry.getKey(); // 列索引
//
//                Integer key = entry.getKey();
//                if (key==9){
//                    String value = entry.getValue();
//                    comments.add(value);
//                }
//                // 处理每个单元格的值
//
//            }
//        }
//
//        int count=0;
//
//        List<Integer> cids = commentsMapper.getAllCid();
//        for (Integer cid : cids) {
//            CommentsWithBLOBs commentsWithBLOBs = commentsMapper.selectByPrimaryKey(cid);
//            commentsWithBLOBs.setCommentcontent(comments.get(count));
////            commentsWithBLOBs.setCommentcontent("\uD83C\uDF43");
//            System.out.println(comments.get(count));
//            commentsMapper.updateByPrimaryKeySelective(commentsWithBLOBs);
//
//            count=count+1;
//        }
//
//
//
//
//        return "2";
//    }

}
