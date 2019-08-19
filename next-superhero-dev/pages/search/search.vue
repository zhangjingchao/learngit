<template>
	<view class="page">
		<view class="search-block">
			<view class="search-ico-wapper">
				<image src="../../static/icos/search.png" class="search-ico"></image>
			</view>
			<input placeholder="搜索预告" maxlength="10" class="search-text" focus />
		</view>
		<view class="movie-list page-block">
			<view v-for="trailer in trailerList" class="movie-wapper">
				<image :src="trailer.poster" class="poster"></image>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				trailerList: [],
				keywords: "", // 搜索的关键字
				page: 1, // 当前第几页
				totalPages: 1 // 总页数
			}
		},
		onLoad() {
			var me = this;
			
			uni.showLoading({
				mask: true,
				title: "请稍后..."
			});
			uni.showNavigationBarLoading();
			
			var serverUrl = me.serverUrl;
			// 查询猜你喜欢数据列表
			uni.request({
				url: serverUrl + '/search/list?keywords=&page=1&pageSize=15',
				method: "POST",
				success: (res) => {
					// 获取真实数据之前，务必判断状态是否为200
					if (res.statusCode == 200) {
						// debugger;
						var trailerList = res.data.rows;
						me.trailerList = trailerList;
					}
				},
				complete: () => {
					uni.hideNavigationBarLoading();
					uni.hideLoading();
				}
			});
		},
		methods: {
			pagedTrailerList(keywords, page, pageSize) {
				var me = this;
				uni.showLoading({
					mask: true,
					title: "请稍后..."
				});
				uni.showNavigationBarLoading();

				//中获取服务器的地址
				// 通过挂载到main.js，作为全局变量
				var serverUrl = me.serverUrl;

				// 查询猜你喜欢数据列表
				uni.request({
					url: serverUrl + '/search/list?keywords=' + keywords + '&page=' + page + '&pageSize=' + pageSize,
					method: "POST",
					success: (res) => {
						// 获取真实数据之前，务必判断状态是否为200
						if (res.statusCode == 200) {
							console.log(res.data);
							var trailerList = res.data.rows;
							me.trailerList = me.trailerList.concat(trailerList);
							me.totalPages = res.data.total; // 获取总页数
							me.page = page; // 覆盖当前页面里的page
						}
					},
					complete() {
						uni.stopPullDownRefresh();
						uni.hideLoading();
						uni.hideNavigationBarLoading();
					}
				});
				debugger;
			},
			searchMe(e) {
				var me = this;
				// 获取搜索的内容
				var value = e.detail.value;
				me.keywords = value;
				me.trailerList = [];

				me.pagedTrailerList(value, 1, 15);
			}
		}
	}
</script>

<style>
	@import url("search.css");
</style>
