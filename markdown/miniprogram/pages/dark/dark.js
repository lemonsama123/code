//获取应用实例
const app = getApp();
Page({
    data: {
        isLoading: true,
        article: {}
    },
    onLoad: function () {
        const _ts = this;

        app.getText('https://636c-cloud1-4gm9kb19e10a611c-1311792482.tcb.qcloud.la/IO%E6%B5%81.md?sign=9e120d619960f378e74ed18de9708bb3&t=1652962069', res => {
            let obj = app.towxml(res.data, 'markdown', {
                theme: 'dark',
                events: {
                    tap: (e) => {
                        console.log('tap', e);
                    }
                }
            });

            _ts.setData({
                article: obj,
                isLoading: false
            });
        });

    }
})