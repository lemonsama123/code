wx.cloud.init()
Page({
    data: {
        key: '',
        docs: []
    },
    getData() {
        wx.showLoading({
            title: '加载中...'
        })
        wx.cloud.callFunction({
            name: 'getDataWithFilter',
            data: {
                _key: this.data.key
            }
        }).then(res => {
            this.setData({
                docs: res.result.data
            })
        }).catch(err => {
        })
        wx.hideLoading()
    },
    onLoad(options) {
        this.setData({
            key: options.key
        })
        this.getData(options.key)
    },
    onClick(e) {
        wx.navigateTo({
            url: '/pages/light/light?url=' + e.currentTarget.dataset.url,
        })
    },
    onPullDownRefresh() {
        this.getData()
        wx.stopPullDownRefresh()
    },
})