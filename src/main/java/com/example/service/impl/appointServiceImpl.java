//package com.example.service.impl;
//
//import com.example.bean.patient;
//import com.example.mapper.AppointMapper;
//import com.example.service.appointService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class appointServiceImpl implements appointService {
//    @Autowired
//    private AppointMapper appointMapper;
//
//
//    @Override
//    public List<patient> selectAll() {
//        return appointMapper.selectAll();
//    }
//
//    @Override
//    public int deleteubyId(int param) {
//        return appointMapper.deleteubyId(param);
//    }
//
//    @Override
//    public int deleteByIds(List<Long> longs) {
//        return appointMapper.deleteByIds(longs);
//    }
//
//    @Override
//    public Integer save(patient patient){
//        if (patient.getId()==null){
//            return appointMapper.insert(patient);
//        }else {
//            return  appointMapper.updatepatient(patient);
//        }
//    }
//
//    @Override
//    public List<patient> searchUsers(String keyword) {
//        return appointMapper.searchpatients(keyword);
//    }
//}
//
