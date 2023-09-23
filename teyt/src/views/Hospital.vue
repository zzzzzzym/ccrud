<template>
  <div>
    <el-container style="min-height: 100vh; ">
      <el-aside :width="sideWidth+'px'" style="background-color: rgb(227,232,239);">
        <el-menu :default-openeds="['1', '3']" style="min-height: 100%;overflow-x: hidden"
                 background-color="rgb(48,65,86)"
                 text-color="#fff"
                 active-text-color="#ffd04b"
                 :collappse_transition="false"
                 :collapse="isCollapse"
        >
          <div style="height: 60px;line-height: 60px;text-align: center">
            <img src="../assets/logo.png" alt="" style="width: 20px; position: relative;top: 5px;margin-right: 5px">
            <b style="color: #f5eeee" v-show="logoTextShow">预约挂号系统</b>
          </div>
          <el-menu-item >
            <i class="el-icon-menu"></i>
            <span slot="title">首页</span>
          </el-menu-item>
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-message"></i>
              <span slot="title">用户管理</span></template>
            <el-menu-item index="1-1">医生信息管理</el-menu-item>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-menu"></i>
              <span slot="title">系统管理</span>
            </template>
            <!--            <el-menu-item index="2-1">医生管理</el-menu-item>-->
            <el-menu-item index="2-2">科室管理</el-menu-item>
            <el-menu-item index="2-4">排班管理</el-menu-item>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-setting"></i>
              <span slot="title">挂号管理</span></template>
            <el-menu-item index="3-4-1">挂号处理</el-menu-item>
            <el-menu-item index="3-4-1">挂号数据记录</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style=" font-size: 12px ;border-bottom: 1px solid #ccc; line-height: 60px;display: flex">
          <div style="flex: 1;font-size: 20px">
            <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>
          </div>
          <el-dropdown style="width: 70px;cursor: pointer">
            <span>管理员</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>个人信息</el-dropdown-item>
              <el-dropdown-item>退出</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>

        </el-header>

        <el-main>
          <div style="margin: 10px 0">
            <el-input style="width: 300px" placeholder="请输入信息" suffix-icon="el-icon-search"></el-input>
            <el-button class="ml-5" type="primary">搜索</el-button>
          </div>

          <div style="margin: 10px 0">
            <el-button type="primary">新增 <i class="el-icon-circle-plus-outline"></i></el-button>
            <el-button type="danger">批量删除 <i class="el-icon-remove-outline"></i></el-button>

          </div>
          <el-table :data="tableData" border srtripe :header-cell-class-name="headerBg">
            <el-table-column prop="id" label="编号" width="140"></el-table-column>
            <el-table-column prop="name" label="用户名" width="140"></el-table-column>
            <el-table-column prop="dep" label="手机" width="120"></el-table-column>
            <el-table-column prop="phone" label="邮箱" width="120"></el-table-column>
            <el-table-column prop="address" label="角色" width="120"></el-table-column>
            <el-table-column prop="time" label="创建时间" width="150"></el-table-column>
            <el-table-column label="操作">
              <template   slot-scope="scope">
                <el-button type="success" @click="alterUser(scope.row)">编辑 <i class="el-icon-edit"></i></el-button>
                <el-button type="danger" @click="del(scope.row)" >删除<i class="el-icon-delete"></i></el-button>
              </template>
            </el-table-column>
          </el-table>
          <div style="padding: 10px 0">
            <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="pageNum"
              :page-sizes="[2, 5, 10, 20]"
              :page-size="pageSize"
              layout="total, sizes, prev, pager, next, jumper"
              :total="total">
            </el-pagination>
          </div>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data () {
    return {
      tableData:[],
      total:0,
      pageNum: 1,
      pageSize:2,
      msg:"鸡哥",
      collapseBtnClass: 'el-icon-s-fold',
      isCollapse: false,
      sideWidth: 200,
      logoTextShow:true,
      headerBg:' headerBg'

    }
  },
  created() {
    this.load()
  },
  mounted(){
    this.selectAll()

  },
  methods:{
    collapse() {  //收缩事件
      this.isCollapse=! this.isCollapse
      if (this.isCollapse){
        this.sideWidth=64
        this.collapseBtnClass= 'el-icon-s-unfold'
        this.logoTextShow=false
      }else {
        this.sideWidth=200
        this.collapseBtnClass='el-icon-s-fold'
        this.logoTextShow=true
      }
    },
    load() {
      fetch("http://localhost:8081/user/page?pageNum="+this.pageNum+"&pageSize="+this.pageSize+"").then(res =>res.json()).then(res =>{
        console.log(res)
        this.tableData = res.data
        this.total = res.total
      })
    },
    handleSizeChange(pageSize) {
      console.log(pageSize);
      this.pageSize = pageSize
      this.load()
    },

    handleCurrentChange(pageNum) {
      console.log(pageNum);
      this.pageNum = pageNum
      this.load()
    },
    selectAll(){

      let _this=this
      axios({
        url:'http://localhost:9090/user/hospital',
        method:'get',
        params:{

        }
      }).then(repos=>{
        _this.tableData=repos.data
      })
    },
  }
}

</script>

<style>
.headerBg{
  background: #eee !important;
}
</style>
