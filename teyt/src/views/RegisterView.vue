<template>
  <div class="login-wrap">
    <el-form ref="form" :model="form">
      <h1 class="title" style="text-align: center">注册</h1>
      <div  style="display: flex;margin-top: 50px; flex-direction: column; width: 100%;height: 250px;align-items: center;justify-content: center">
        <el-form-item >
          <el-input class="my-input" type="text" v-model="form.username" placeholder="用户账号" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item >
          <el-input class="my-input" type="password" v-model="form.password" placeholder="用户密码" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item >
          <el-input class="my-input" type="text" v-model="form.address" placeholder="用户地址" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item >
          <el-input class="my-input" type="text" v-model="form.phone" placeholder="用户电话" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item >
          <el-input class="my-input" type="text" v-model="form.email" placeholder="用户邮箱" autocomplete="off"></el-input>
        </el-form-item>
      </div>
      <div style="display: flex;width: 100%;justify-content: center">
        <el-button  type="primary" @click="register">注册</el-button>
        <el-button type="primary" @click="doLogin" >返回登录</el-button>
      </div>



    </el-form>

  </div>
</template>


<script>
import axios from 'axios';
export default({
name:" RegisterView",
  data() {
    return {
      form: {
        username: '',
        password: '',
        address:'',
        phone:'',
        email:''
      }
    }
  },

  methods: {
    register() {
      axios.post('http://localhost:9090/user/register/', {
        username: this.form.username,
        password: this.form.password,
        address:this.form.address,
        phone:this.form.phone,
        email:this.form.email
      }).then(res => {
        if(res.data===-1){
          // 用户名已存在的情况，使用ElMessage组件显示提示信息给用户
          this.$message.error("用户名已存在，请尝试其他用户名");;

        }else if (res.data===1){
          this.$message.success("注册成功！请登录");
          // 例如跳转到登录页面
          this.$router.push('/Login');
        }else {
          // 注册失败或其他情况，使用ElMessageBox组件显示失败提示信息
          this.$alert("注册失败，请稍后再试", "错误提示", {
            confirmButtonText: "确定"
          });
        }

      }).catch(err => {
        console.log(err);
        this.$message.error("失败")

      })
    },
    doLogin() {
      this.$router.push('/Login');
    },

  }


})



</script>
<style>
.my-input{
  width: 400px;
}
</style>
