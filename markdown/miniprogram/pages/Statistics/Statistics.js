// pages/Statistics/Statistics.js

let Charts = require('../../wxcharts/wxcharts-min');


Page({

    /**
     * 页面的初始数据
     */
    data: {
        isLoading: true
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad(options) {
        this.runLlineCanva();
        this.setData({
            isLoading : false
        })
    },

    runLlineCanva: function () {
        let windowWidth = 320;
        try {
            let res = wx.getSystemInfoSync();
            windowWidth = res.windowWidth;
        } catch (e) {
            // do something when get system info failed
        }
        new Charts({
            canvasId: 'canvas1',
            type: 'pie',
            series: [{ name: '一班', data: 50 }, { name: '二班', data: 30 }, { name: '三班', data: 20 }, { name: '四班', data: 18 }, { name: '五班', data: 8 }],
            width: windowWidth - 10,
            height: windowWidth - 10,
            dataLabel: true,
        });
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