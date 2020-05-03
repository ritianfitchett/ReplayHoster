module.exports = {
  "transpileDependencies": [
    "vuetify"
  ],
  lintOnSave: false,
  devServer: {
    proxy: {
      '/api/vue/v1': {
         target: 'http://localhost:8079',
         changeOrigin: true
       },
      '/api/group/v1': {
         target: 'http://localhost:8081',
         changeOrigin: true
       },
       '/api/environment/v1': {
         target: 'http://localhost:8081',
         changeOrigin: true
       }
    }
  }
}