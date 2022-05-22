// pages/Statistics/Statistics.js
let Charts = require('../../wxcharts/wxcharts-min');

Page({

    /**
     * 页面的初始数据
     */

    data: {
        type: 1,
        isLoading: true,
        docs: [],
        tags: ['Java', 'C/C++', 'Python', 'C#', 'Go', 'PHP', 'Shell', '算法', 'Vue'],
        series1: [{ name: '一班', data: 50 }]
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
        this.getData()
        this.init(this.data.series1)

        this.setData({
            isLoading: false
        })

        this.runLlineCanva();
        console.log(this.data.docs)
    },

    init: function (series1) {
        const db = wx.cloud.database()
        console.log(this.data.series1)
        console.log("this.data.series1")
        let series2 = [{ name: '一班', data: 50 }, { name: '二班', data: 30 }, { name: '三班', data: 20 }, { name: '四班', data: 18 }, { name: '五班', data: 8 }];
        // let series2 = [];

        let index = 0;

        for (let i = 0; i < this.data.tags.length; i++) {
            console.log(this.data.tags[i])

            db.collection('docs').where({
                tag: this.data.tags[i]
            }).count().then(res => {
                // console.log(res.total)
                // console.log(res.total)
                if (res.total != 0) {
                    // series1.splice(1, 0, { name: this.data.tags[i], data: res.total });
                    series1.push({ name: this.data.tags[i], data: res.total })
                    ++index;
                }
                // series2.push(res.total)
            }).catch(err => {
            })
        }
        this.runLlineCanva()
    },

    runLlineCanva: function () {
        const db = wx.cloud.database()

        // console.log(series1)
        // let series2 = [{ name: '一班', data: 50 }, { name: '二班', data: 30 }, { name: '三班', data: 20 }, { name: '四班', data: 18 }, { name: '五班', data: 8 }];
        // // let series2 = [];

        // let index = 0;

        // for (let i = 0; i < this.data.tags.length; i++) {
        //     console.log(this.data.tags[i])

        //     db.collection('docs').where({
        //         tag: this.data.tags[i]
        //     }).count().then(res => {
        //         // console.log(res.total)
        //         // console.log(res.total)
        //         if (res.total != 0) {
        //             series1.splice(1, 0, { name: this.data.tags[i], data: res.total });
        //             // series1.push({ name: this.data.tags[i], data: res.total })
        //             ++index;
        //         }
        //         // series2.push(res.total)
        //     }).catch(err => {
        //     })
        // }
        // console.log(series2)
        let windowWidth = 320;
        try {
            let res = wx.getSystemInfoSync();
            windowWidth = res.windowWidth;
        } catch (e) {
            // do something when get system info failed
        }


        // console.log(series1)
        new Charts({
            canvasId: 'canvas1',
            type: 'pie',
            series: this.data.series1,
            width: windowWidth - 10,
            height: windowWidth - 20,
            dataLabel: true,
        });
        // new Charts({
        //     canvasId: 'canvas2',
        //     type: 'column',
        //     categories: this.data.tags,
        //     series: [{
        //         name: '成交量1',
        //         data: series2
        //     }],
        //     yAxis: {
        //         format: function (val) {
        //             return val + '';
        //         }
        //     },
        //     width: windowWidth - 10,
        //     height: windowWidth - 10,
        //     dataLabel: true,
        // });
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