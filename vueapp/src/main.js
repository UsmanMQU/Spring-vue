// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.

import Vue from 'vue'
import VueRouter from 'vue-router'
import VueResource from 'vue-resource'
import App from './App'
import Users from './components/Users'
import Test from './components/Test'

Vue.use(VueResource)
Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  base: __dirname,
  routes: [
    {path: '/', component: Users},
    {path: '/test', component: Test}
  ]
});
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  router,
  template: `

  <div id="app">
  <ul>
  <li style="list-style-type:none"><router-link to="/">Add accounts</router-link></li>
  <li style="list-style-type:none"><router-link to="/test">Accounts</router-link></li>
  </ul>
  <router-view>></router-view>
  </div>
`,
}).$mount('#app')
