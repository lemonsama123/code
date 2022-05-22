// pages/Statistics/Statistics.js

let Charts = require('../../wxcharts/wxcharts-min');

Page({

    /**
     * 页面的初始数据
     */
    data: {
        type: 2,
        isLoading: true,
        docs: []
    },

    /**
     * 生命周期函数--监听页面加载
     */

    getData() {
        wx.cloud.callFunction({
            name: 'getData'
        }).then(res => {
            console.log(res)
            this.setData({
                docs: res.result.data
            })
        }).catch(err => {
            console.log('test3')
            console.log(err)
        })
    },

    change(e) {
        console.log(e.currentTarget.dataset.type)
        this.setData({
            type: e.currentTarget.dataset.type
        })
        this.runLlineCanva()

    },

    onLoad(options) {
        this.runLlineCanva();
        this.setData({
            isLoading: false
        })
        this.getData()
        console.log(this.data.docs)
    },

    runLlineCanva: function () {
        let windowWidth = 320;
        try {
            let res = wx.getSystemInfoSync();
            windowWidth = res.windowWidth;
        } catch (e) {
            // do something when get system info failed
        }
        let series1 = [];
        // for (let i = 0; i < this.data.docs.length; ++i) {
        //     console.log(i)
        //     series1.push({ name: '一班', data: 50 });
        // }
        let series2 = [{ name: '一班', data: 50 }, { name: '二班', data: 30 }, { name: '三班', data: 20 }, { name: '四班', data: 18 }, { name: '五班', data: 8 }];
        new Charts({
            canvasId: 'canvas1',
            type: 'pie',
            series: series2,
            width: windowWidth - 10,
            height: windowWidth - 10,
            dataLabel: true,
        });
        new Charts({
            canvasId: 'canvas2',
            type: 'column',
            categories: ['一班', '二班', '三班', '四班', '五班'],
            series: [{
                name: '成交量1',
                data: [15, 20, 45, 37, 4, 80]
            }],
            yAxis: {
                format: function (val) {
                    return val + '';
                }
            },
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