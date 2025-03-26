$(function(){
	var app = new Vue({
		el : '#app',
		components : {
			'top-menu' : httpVueLoader('/js/vue/components/common/top_menu.vue'),
			'bottom-info' : httpVueLoader('/js/vue/components/common/bottom_info.vue')
		},
		router : router,
		beforeCreate : function(){
			if(sessionStorage.user_login_chk != undefined){
				if(sessionStorage.user_login_chk == 'true'){
					this.$store.state.user_login_chk = true
				}
				
				this.$store.state.user_id = sessionStorage.user_id
				this.$store.state.user_name = sessionStorage.user_name
				this.$store.state.user_idx = parseInt(sessionStorage.user_idx)
			}
		}
	})
})