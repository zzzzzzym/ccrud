import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '../views/Home'
import About from '../views/About'
import Login from '../views/Login'
import RegisterView from '../views/RegisterView'
import Hospital from '../views/Hospital'
import patient from '../views/patient'
import doctor from '../views/doctor'
import department from '../views/department'
import schedule from '../views/schedule'
import appoint from '../views/appoint'
import iview from '../views/iview'
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/appoint',
      name: 'appoint',
      component: appoint
    },
    {
      path: '/login',
      name: 'iview',
      component: iview
    },
    {
      path: '/schedule',
      name: 'schedule',
      component: schedule
    },
    {
      path: '/department',
      name: 'department',
      component: department
    },
    {
      path: '/doctor',
      name: 'doctor',
      component: doctor
    },
    {
      path: '/patient',
      name: 'patient',
      component: patient
    },
    {
      path: '/Hospital',
      name: 'Hospital',
      component: Hospital
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/RegisterView',
      name: 'RegisterView',
      component: RegisterView
    },
    {
      path: '/About',
      name: 'About',
      component: About
    },
    {
      path: '/',
      name: 'Home',
      component: Home
    },
  ]
})
