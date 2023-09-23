// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/global.css'
import axios from 'axios';
// import ViewUIPlus from 'view-ui-plus'
// import 'view-ui-plus/dist/styles/viewuiplus.css'
// import ViewUI from 'view-design';
// import 'view-design/dist/styles/iview.css';
// 把axios挂载到Vue的原型上
Vue.prototype.$axios = axios;
Vue.config.productionTip = false
Vue.use(ElementUI,{size:"mini"});
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  // ViewUIPlus,
  // ViewUI,
  components: { App },
  template: '<App/>'
})
