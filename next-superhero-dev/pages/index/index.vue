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
					<!-- <view class="movie-score-wrapper">
						<image src="../../static/icos/star-yellow.png" class="star-icon"></image>
						<image src="../../static/icos/star-yellow.png" class="star-icon"></image>
						<image src="../../static/icos/star-yellow.png" class="star-icon"></image>
						<image src="../../static/icos/star-yellow.png" class="star-icon"></image>
						<image src="../../static/icos/star-yellow.png" class="star-icon"></image>
						<view class="movie-score">
							9.1
						</view>
					</view> -->
					<trailer-stars :innerScore="hotSuperHero.score" showNum="1"></trailer-stars>
				</view>
			</view>
		</scroll-view>
		<!-- 热门超英 end -->

		<!-- 热门预告 start -->
		<view class="page-block super-hot">
			<view class="hot-title-wapper">
				<image src="../../static/icos/interest.png" class="hot-icon"></image>
				<view class="hot-title">
					热门预告
				</view>
			</view>
		</view>
		<view class="hot-movie page-block">
			<video v-for="trailer in hotTrailerList" :src="trailer.trailer" :poster="trailer.poster" class="hot-movie-single"></video>
		</view>
		<!-- 热门预告  end -->

		<!-- 猜你喜欢 start -->
		<view class="page-block super-hot">
			<view class="hot-title-wapper">
				<image src="../../static/icos/guess-u-like.png" class="hot-icon"></image>
				<view class="hot-title">
					猜你喜欢
				</view>
			</view>
		</view>
		<view class="page-block guess-u-like">
			<view class="sigle-like-movie">
				<image src="http://122.152.205.72:88/superhero/xman/Logan/poster.png" class="like-movie"></image>
				<view class="moive-desc">
					<view class="moive-title">
						表附小大战仇人表附小大战仇表附小大战仇
					</view>
					<trailer-stars :innerScore="9.1" showNum="0"></trailer-stars>

					<view class="moive-info">
						故事发生在2029年，彼时，
					</view>
					<view class="moive-info">
						X战警早已经解散
					</view>
				</view>
				<view class="moive-oper">
					<image src="../../static/icos/praise.png" class="praise-ico"></image>
					<view class="praise-me">
						点赞
					</view>
					<view :animation="animationData" class="praise-me animation-opacity">
						+1
					</view>
				</view>
			</view>
		</view>
		<!-- 猜你喜欢  end -->
	</view>
</template>

<script>
	// 获取common.js中的服务器地址
	//import common from "../../common/common.js";

	//导入自定义组件
	import trailerStars from "../../components/trailerStars.vue"

	export default {
		data() {
			return {
				carouselList: [],
				hotSuperHeroList: [],
				hotTrailerList: [],
				animationData: {}
			}
		},
		onUnload() {
			// 页面卸载的时候，清楚动画对象
			this.animationData = {};
		},
		onLoad() {
			var me = this;
			animationData

			// #ifdef APP-PLUS || MP-WEIXIN
			// 在页面创建的时候，创建一个临时动画对象
			this.animation = uni.createAnimation();
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

			// 查询热门超英
			uni.request({
				url: serverUrl + '/index/movie/hot?type=trailer',
				method: "POST",
				success: (res) => {
					// 获取真实数据之前，务必判断状态是否为200
					if (res.statusCode == 200) {
						var hotTrailerList = res.data;
						me.hotTrailerList = hotTrailerList;
					}
				}
			});
		},
		methods: {
			// 实现动画点赞效果
			praiseMe() {
				// 构建动画数据，并且通过step来表示这组动画的完成
				this.animation.translateY(-60).opacity(1).step({
					duration: 400
				});

				// 导出动画数据到view组件，实现组件的动画效果
				this.animationData = this.animation.export();

				// 还原动画
				setTimeout(function() {
					this.animation.translateY(0).opacity(0).step({
						duration: 0
					})
				}.bind(this), 500);
			}
		},

		components: {
			trailerStars
		}
	}
</script>

<style>
	@import url("index.css");
</style>
