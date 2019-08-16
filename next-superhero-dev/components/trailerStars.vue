<template name="trailerStars">
	<view class="movie-score-wrapper">
		<image v-for="yellow in yellowScore" src="../static/icos/star-yellow.png" class="star-icon"></image>
		<image v-for="gray in grayScore" src="../static/icos/star-gray.png" class="star-icon"></image>
		<view class="movie-score" v-if="showNum==1">
			{{innerScore}}
		</view>
	</view>
</template>

<script>
	export default {
		name: 'trailerStars',
		data() {
			return {
				yellowScore: 0,
				grayScore: 5
			};
		},
		props: {
			innerScore: 0, //定义外部传入的分数
			showNum: 0 //是否需要显示具体的分数 1：显示 2：不显示
		},

		// 生命周期，组件创建完成后别调用
		created() {
			var tempScore = 0;
			if (this.innerScore != null && this.innerScore != undefined && this.innerScore != '') {
				tempScore = this.innerScore;
			}

			var yellowScore = parseInt(tempScore / 2);
			var grayScore = 5 - yellowScore;

			this.yellowScore = yellowScore;
			this.grayScore = grayScore;
		}
	}
</script>

<style>
	.movie-score-wrapper {
		display: flex;
		flex-direction: row;
	}

	.star-icon {
		width: 20upx;
		height: 20upx;
		margin-top: 6upx;
	}

	.movie-score {
		font-size: 12px;
		color: grey;
		margin-left: 8upx;
	}
</style>
