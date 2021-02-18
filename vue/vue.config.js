module.exports = {
    devServer: {
        proxy: {
            '/api/homemarket': {
                target: "http://localhost:8080",
                pathRewrite: {
                    '/api/homemarket': '/'
                }
            }
        }
    }
}