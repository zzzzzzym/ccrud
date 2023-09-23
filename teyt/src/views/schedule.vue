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

          <div style="margin-bottom: 30px">
            <el-breadcrumb separator="/">
              <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
              <el-breadcrumb-item><a href="/">活动管理</a></el-breadcrumb-item>
            </el-breadcrumb>
          </div>
          <div style="margin: 10px 0">
            <el-input style="width: 200px" suffix-icon="el-icon-search" v-model="keyword" placeholder="请输入关键字"></el-input>
            <!--          <el-input style="width: 200px" suffix-icon="el-icon-message" v-model="email" class="ml-5" placeholder="请输入邮箱"></el-input>-->
            <!--          <el-input style="width: 200px" suffix-icon="el-icon-position"  v-model="address" class="ml-5"  placeholder="请输入地址"></el-input>-->
            <el-button class="ml-5" type="primary" @click="search">搜索</el-button>
          </div>
          <div style="margin: 10px 0">
            <el-button type="primary" @click="Add">新增 <i class="el-icon-circle-plus"></i></el-button>
            <el-button type="danger" @click="delbatch" >批量删除  <i class="el-icon-delete"></i></el-button>
            <!--          <el-button type="primary">导入 <i class="el-icon-bottom"></i></el-button>-->
            <!--          <el-button type="primary">导出 <i class="el-icon-top"></i></el-button>-->

          </div>
          <el-table :data="tableData" border stripe :header-cell-class-name="headerBg" @selection-change="handleSelectionChange"  >

            <el-table-column
              type="selection"
              width="55">
            </el-table-column>
            <el-table-column prop="id" label="编号" width="140">
            </el-table-column>
            <el-table-column prop="name" label="姓名" width="120">
            </el-table-column>
            <el-table-column prop="dep" label="科室">
            </el-table-column>
            <el-table-column prop="office" label="职位">
            </el-table-column>
            <el-table-column prop="address" label="地址">
            </el-table-column>
            <el-table-column prop="time" label="时间">
            </el-table-column>
            <el-table-column prop="phone" label="电话">
            </el-table-column>
            <el-table-column label="操作">
              <template   slot-scope="scope">
                <el-button type="success" @click="alterUser(scope.row)">编辑 <i class="el-icon-edit"></i></el-button>
                <el-button type="danger" @click="del(scope.row)" >删除<i class="el-icon-delete"></i></el-button>
              </template>
            </el-table-column>
          </el-table>

          <div style="padding: 10px 0">
            <div style="padding: 10px 0">
              <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="pageNum"
                :page-sizes="[2,5, 10, 20]"
                :page-size="pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total">
              </el-pagination>

            </div>
            <el-dialog
              title="添加用户"
              :visible.sync="dialogVisibles"
              width="30%">
              <el-form ref="form" :model="UserForm" label-width="80px" >
                <el-form-item label="名字">
                  <el-input v-model="UserForm.username"></el-input>
                </el-form-item>
                <el-form-item label="地址">
                  <el-input v-model="UserForm.address"></el-input>
                </el-form-item>
                <el-form-item label="邮箱">
                  <el-input v-model="UserForm.email"></el-input>
                </el-form-item>
                <el-form-item size="large">
                  <el-button type="primary" @click="addStudent">确认添加</el-button>
                  <el-button @click="dialogVisibles=false">取消</el-button>
                </el-form-item>
              </el-form>
            </el-dialog>

            <!--编辑对话框-->
            <el-dialog
              title="修改用户"
              :visible.sync="dialogVisible"
              width="30%">
              <el-form ref="form" :model="UserForm" label-width="80px" >
                <el-form-item label="用户名">
                  <el-input v-model="UserForm.username"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                  <el-input v-model="UserForm.password"></el-input>
                </el-form-item>
                <el-form-item label="昵称">
                  <el-input v-model="UserForm.nickname"></el-input>
                </el-form-item>
                <el-form-item label="地址">
                  <el-input v-model="UserForm.address"></el-input>
                </el-form-item>
                <el-form-item label="电话">
                  <el-input v-model="UserForm.phone"></el-input>
                </el-form-item>
                <el-form-item label="邮箱 ">
                  <el-input v-model="UserForm.email"></el-input>
                </el-form-item>
                <el-form-item size="large">
                  <el-button type="primary" @click="updateuser">确认修改</el-button>
                  <el-button @click="dialogVisible=false">取消</el-button>
                </el-form-item>
              </el-form>
            </el-dialog>


          </div>
        </el-main>

      </el-container>

    </el-container>


  </div>
</template>
<script>
import axios from "axios";

export default {
  data(){

    return {
      keyword: '',
      UserForm:{},
      dialogVisible:false,
      dialogVisibles:false,
      //编辑对话框的显示和隐藏
      collapseBtnClass: 'el-icon-s-fold',
      isCollapse:false,
      sideWidth:200,
      logoTextShow:true,
      headerBg:'headerBg',
      selectedIds:[],
      multipleSelection: [],
      currentPage:1,
      //请求的数据
      tableData: [],
      //搜索的字段
      usercode: '',
      address:'',
      username:'',
      email:'',
      //总条目数默认显示0就行
      total: 0,
      //从第几页开始查询记录
      pageNum: 1,
      //每页显示两条记录
      pageSize: 2
    }
  },
  mounted(){
    this.selectAll()

  },
  methods:{
    search() {
      axios.get("http://localhost:9090/user/search", {
        params: {
          keyword: this.keyword
        }
      }).then(response => {
        this.tableData = response.data;
      }).catch(error => {
        console.error(error);
      })
    },
    look(){
      this.selectAll();
    },
    handleAddNew(){
      this.dialogVisibles=true;
    },
    alterUser(row){
      this.dialogVisible=true;
      this.UserForm=row;
    },
    updateuser(){
      let _this =this;
      _this.selectAll();
      axios.post("http://localhost:9090/user/add",this.UserForm).then(result=>{
        if (result.data){
          this.$message.success("修改成功") //弹出成功的消息框

          this.dialogVisible=false;
          _this.selectAll() //重新加载表格
        }
      })

    },
    addStudent(){
      let _this =this;

      axios.post("http://localhost:9090/user/add",this.UserForm).then(result=>{
        if (result.data){

          this.$message.success("添加成功") //弹出成功的消息框
          _this.dialogVisibles=false;
          _this.selectAll() //重新加载表格
        }
      })
    },

    Add(){
      this.dialogVisibles=true;
      this.UserForm={}
    },
    load() {

      let _this;
      _this = this
      // _this=this
      axios.get("http://localhost:9090/user/page?pageNum=" + _this.pageNum
        + "&pageSize=" + _this.pageSize + "&email=" + _this.email + "&username=" + _this.username + "&address=" + _this.address).then(function (resp) {
        _this.tableData = resp.data
        _this.total = res.total;
      })


    },

    //删除学生
    del(row){
      // let sid = row.id;
      this.$confirm('此操作将永久删除'+row.username+'账号信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        axios.delete("http://localhost:9090/user/delete/"+row.id).then(result=>{
          if (result.data){
            this.$message.success("删除成功") //弹出成功的消息框
            // this.initTable() //重新加载表格
            this.selectAll();
          }
        })   }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });

    },

    handleSizeChange(pageSize) {
      this.pageSize = pageSize;
      this.load()
    },
    handleCurrentChange(pageNum) {
      this.pageNum = pageNum;
      this.load()
    },

    selectAll(){

      let _this=this
      axios({
        url:'http://localhost:9090/user',
        method:'get',
        params:{

        }
      }).then(repos=>{
        _this.tableData=repos.data
      })
    },
    delbatch(){

      // console.log(this.multipleSelection.length)
      for (let i = 0; i < this.multipleSelection.length; i++) {
        let selectedElement = this.multipleSelection[i]
        this.selectedIds[i] = selectedElement.id
      }
      console.log(this.selectedIds[0])
      let _this = this
      this.$confirm('此操作将永久删除'+'账号信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        axios({
          method: 'DELETE',
          url: `http://localhost:9090/user/deleteBatch/${_this.selectedIds}`
        }).then(repos1 => {
          if (repos1.data){
            this.$message.success("删除成功") //弹出成功的消息框
            this.selectAll();
          }

        }) }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });

    },
    collapse(){
      this.isCollapse= !this.isCollapse
      if (this.isCollapse){
        this.sideWidth=70
        this.collapseBtnClass='el-icon-s-unfold',
          this.logoTextShow=false
      }else
      {
        this.sideWidth=200
        this.collapseBtnClass='el-icon-s-fold',
          this.logoTextShow=true
      }

    }
    ,
    handleSelectionChange(val) {
      this.multipleSelection = val;


    }
  }
}

</script>
<style>
.el-header {
  background-color: #B3C0D1;
  color: #333333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
.headerBg{
  background: #42b983!important;
}
</style>
