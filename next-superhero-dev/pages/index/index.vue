<template>
	<view class="page">
		<!-- 轮播图 start -->
		<swiper :indicator-dots="true" :autoplay="true" class="carousel">
			<swiper-item v-for="carousel in carouselList">
				<image :src="carousel.poster" class="carousel"></image>
			</swiper-item>
		</swiper>
		<!-- 轮播图 end -->
		
		<!-- 热门超英 start -->
		<view class="page-block super-hot">
			<view class="hot-title-wapper">
				<image src="../../static/icos/hot.png" class="hot-icon"></image>
				<view class="hot-title">
					热门超英
				</view>
			</view>			
		</view>
		<scroll-view scroll-x="true" class="page-block hot">
			<view class="single-poster" v-for="hotSuperHero in hotSuperHeroList">
				<view class="poster-wapper">
					<image :src="hotSuperHero.cover" class="poster"></image>
					<view class="movie-name">
						{{hotSuperHero.name}}
					</view>
					<view class="movie-score-wrapper">
						<image src="../../static/icos/star-yellow.png" class="star-icon"></image>
						<image src="../../static/icos/star-yellow.png" class="star-icon"></image>
						<image src="../../static/icos/star-yellow.png" class="star-icon"></image>
						<image src="../../static/icos/star-yellow.png" class="star-icon"></image>
						<image src="../../static/icos/star-yellow.png" class="star-icon"></image>
						<view class="movie-score">
							9.1
						</view>
					</view>
				</view>
			</view>
		</scroll-view>
		<!-- 热门超英 end -->
	</view>
</template>

<script>
	// 获取common.js中的服务器地址
	//import common from "../../common/common.js";
	
	export default {
		data() {
			return {
				carouselList: [],
				hotSuperHeroList:[]
			}
		},
		onLoad() {
			var me = this;

			// #ifdef APP-PLUS || MP-WEIXIN
			// 在页面创建的时候，创建一个临时动画对象
			//this.animation = uni.createAnimation();
			// #endif

			// 获取common.js中的服务器地址
			//var serverUrl = common.serverUrl;
			// 通过挂载到main.js中获取服务器的地址，作为全局变量
			var serverUrl = me.serverUrl;

			// 请求轮播图数据
			uni.request({
				url: serverUrl + '/index/Carousel',
				method: "POST",
				success: (res) => {
					// 获取真实数据之前，务必判断状态是否为200
					if (res.statusCode == 200) {
						var carouselList = res.data;
						me.carouselList = carouselList;
					}
				}
			});

			// 查询热门超英
			uni.request({
				url: serverUrl + '/index/movie/hot?type=superhero',
				method: "POST",
				success: (res) => {
					// 获取真实数据之前，务必判断状态是否为200
					if (res.statusCode == 200) {
						var hotSuperHeroList = res.data;
						me.hotSuperHeroList = hotSuperHeroList;
					}
				}
			});
		},
		methods: {

		}
	}
</script>

<style>
	@import url("index.css");
</style>
