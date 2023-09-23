<template>
  <div class="login-wrap">
    <el-form ref="form" :model="form" :rules="rules">
      <h1 class="title">登录</h1>
      <div style="display: flex;flex-direction: column; width: 100%;height: 250px;align-items: center;justify-content: center">
        <el-form-item  label="账号" prop="username">
          <el-input class="my-input" type="text" v-model="form.username"  placeholder="用户账号" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input class="my-input" type="password" v-model="form.password" placeholder="用户密码" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button  type="primary" @click="doLogin" >登录</el-button>
        </el-form-item>
      </div>

      <el-row style="text-align: center;margin-top: -10px;">
        <el-link type="primary" @click="doRegister">注册账号</el-link> |
        <el-link type="primary" @click="">忘记密码</el-link>
      </el-row>
    </el-form>
  </div>
</template>
<script>
import axios from 'axios'
export default{

  data(){
    return{
      form:{
        username:'',
        password:''
      },
      rules: {
        username: [
          { required: true, message: '用户名不能为空', trigger: 'blur' },
          { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '密码不能为空', trigger: 'blur' },
          { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
        ],
      }
    }
  },

  methods:{
    doLogin(){
      if (!this.form.username) {
        this.$message.error('请输入账号');
        return;
      }

      if (!this.form.password) {
        this.$message.error('请输入密码');
        return;
      }
      if ((this.form.username))
      axios.post('http://localhost:9090/user/login',this.form).then(res=>{
        if(res.data==1){
          this.$message.success("666666666666666666666666666");

          this.$router.push('/');
        }else{
          this.$message.error('哎哟，你干嘛');
          // while (true) {
          //   alert("这是一个弹窗！");
          //   this.$message.error('哎哟，你干嘛');
          // }


        }
      })
    },
    doRegister(){
      this.$router.push('/RegisterView');
    }
  }



}
</script>

<style>
.login-wrap {
  box-sizing: border-box;
  width: 100%;
  height: 100%;
  padding-top: 10%;

  /* background-color: #112346; */
  background-repeat: no-repeat;
  background-position: center right;
  background-size: 100%;
}

.login-container {
  border-radius: 10px;
  margin: 0px auto;
  width: 350px;
  padding: 30px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  text-align: left;
  box-shadow: 0 0 20px 2px rgba(0, 0, 0, 0.1);
}
/*.el-message .el-message__content {*/
/*  font-size: 100px; !* 根据需要调整字体大小 *!*/
/*}*/
.title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
.my-input{
  width: 400px;
}

</style>kground-image: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjEzNjFweCIgaGVpZ2h0PSI2MDlweCIgdmlld0JveD0iMCAwIDEzNjEgNjA5IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiPgogICAgPCEtLSBHZW5lcmF0b3I6IFNrZXRjaCA0Ni4yICg0NDQ5NikgLSBodHRwOi8vd3d3LmJvaGVtaWFuY29kaW5nLmNvbS9za2V0Y2ggLS0+CiAgICA8dGl0bGU+R3
