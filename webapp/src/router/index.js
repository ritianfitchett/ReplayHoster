import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/views/Home'
import Browse from '@/views/Browse'
import Upload from '@/views/Upload'
import Info from '@/views/Info'
import FourOhFour from '@/views/FourOhFour'
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/browse',
      name: 'Browse',
      component: Browse
    },
    {
      path: '/upload',
      name: 'Upload',
      component: Upload
    },
    {
      path: '/info',
      name: 'Info',
      component: Info
    },
    {
      path: '*',
      name: '404',
      component: FourOhFour
    }
  ]
})