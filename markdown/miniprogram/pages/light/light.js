//获取应用实例
const app = getApp();
Page({
    data: {
        isLoading: true,
        article: {}
    },
    onLoad(options) {
        const _ts = this;
        console.log(options)
        console.log(options.url)
        app.getText(options.url, res => {
            let obj = app.towxml(res.data, 'markdown', {
                // theme:'dark',
                events: {
                    tap: e => {
                        console.log('tap', e);
                    },
                    change: e => {
                        console.log('todo', e);
                    }
                }
            });
            console.log(this.data.isLoading)
            _ts.setData({
                article: obj,
                isLoading: false
            });
        });

    }
})