module.exports = {
  "transpileDependencies": [
    "vuetify"
  ],
  lintOnSave: false,
  devServer: {
    proxy: {
      '/api/replay/v1': {
         target: 'http://localhost:8081',
         changeOrigin: true
       },
    }
  }
}