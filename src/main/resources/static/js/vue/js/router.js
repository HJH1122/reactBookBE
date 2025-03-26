var router = new VueRouter({
	routes : [
		{
			path : '/',
			component : httpVueLoader('/js/vue/components/main/main.vue')
		}
	]
})