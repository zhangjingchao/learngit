import Vue from 'vue'
import App from './App'

Vue.config.productionTip = false
//Vue.prototype.serverUrl = "http://39.96.44.100:8080";			// 生产环境
Vue.prototype.serverUrl = "http://localhost:8080"; // 开发环境

// 用户信息
Vue.prototype.getGlobalUser = function(key) {
	var userInfo = uni.getStorageSync("globalUser");
	if (userInfo != null && userInfo != "" && userInfo != undefined) {
		return userInfo;
	} else {
		return null;
	}
}

App.mpType = 'app'

const app = new Vue({
	...App
})
app.$mount()
