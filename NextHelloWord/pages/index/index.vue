<!-- <template><script><style> 这三个标签在每个页面都只能存在一个 -->
<!-- template: View -->
<template>
	<view class="content">
		<image class="logo" src="/static/logo.png"></image>
		<view class="text-area">
			<text class="title">{{title}}</text><br />
			<input type="text" :value="title" @input="change" />
		</view>
		<navigator url="../hello/hello">
			<view>
				I am {{student.age}} age old.<br />
				I have skill such as:{{skill[0]}}，{{skill[1]}}，{{skill[2]}}
			</view>
		</navigator>
	</view>
</template>

<script>
	// VM：协调者 调度器
	export default {
		// Model：所有的数据
		data() {
			return {
				title: 'Hello Next学院',
				student: {
					age: 18
				},
				skill: ["java", "html", "css"]
			}
		},
		onLoad() {

		},
		methods: {
			change(e) {
				var txtTitle = e.detail.value;
				this.title = txtTitle;
			}

		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200upx;
		width: 200upx;
		margin-top: 200upx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50upx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36upx;
		color: #8f8f94;
	}
</style>
