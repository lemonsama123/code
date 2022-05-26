// pages/index/index.js
wx.cloud.init()
Page({
    /**
     * 页面的初始数据
     */
    data: {
        docs: []
    },
    /**
     * 生命周期函数--监听页面加载
     */

    getData() {
        wx.showLoading({
            title: '加载中...',
        })
        wx.cloud.callFunction({
            name: 'getData'
        }).then(res => {
            // console.log(res)
            this.setData({
                docs: res.result.data
            })
        }).catch(err => {
        })
        wx.hideLoading()
    },
    onLoad(options) {
        this.getData()
    },

    onClick(e) {
        console.log(e)
        wx.navigateTo({
            url: '/pages/light/light?url=' + e.currentTarget.dataset.url,
        })
    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady() {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow() {

    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide() {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload() {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh() {
        // console.log("下拉刷新")
        this.getData()
        wx.stopPullDownRefresh()
    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom() {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage() {

    }
})