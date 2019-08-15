import Vue from 'vue'
import App from './App'

Vue.config.productionTip = false
Vue.prototype.serverUrl = "http://localhost:8080";			// 生产环境
// Vue.prototype.serverUrl = "http://localhost:8080";		// 开发环境

App.mpType = 'app'

const app = new Vue({
    ...App
})
app.$mount()
