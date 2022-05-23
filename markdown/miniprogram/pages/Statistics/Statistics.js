// pages/Statistics/Statistics.js



let Charts = require('../../wxcharts/wxcharts-min');

let series1 = [{ name: '一班', data: 50 }, { name: '二班', data: 30 }]




Page({

    /**
     * 页面的初始数据
     */

    data: {
        type: 1,
        isLoading: true,
        docs: [],
        tags: ['Java', 'C/C++', 'Python', 'C#', 'Go', 'PHP', 'Shell', '算法', 'Vue'],

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
        // this.init()

        this.setData({
            isLoading: false
        })

        this.runLlineCanva();
        console.log(this.data.docs)

    },

    // init: function () {
    //     const db = wx.cloud.database()
    //     console.log(series1)
    //     console.log("this.data.series1")
    //     let series2 = [{ name: '一班', data: 50 }, { name: '二班', data: 30 }, { name: '三班', data: 20 }, { name: '四班', data: 18 }, { name: '五班', data: 8 }];
    //     // let series2 = [];

    //     let index = 0;

    //     for (let i = 0; i < this.data.tags.length; i++) {
    //         console.log(this.data.tags[i])

    //         db.collection('docs').where({
    //             tag: this.data.tags[i]
    //         }).count().then(res => {
    //             // console.log(res.total)
    //             // console.log(res.total)
    //             if (res.total != 0) {
    //                 // series1.splice(1, 0, { name: this.data.tags[i], data: res.total });
    //                 series1.push({ name: this.data.tags[i], data: res.total })
    //                 ++index;
    //             }
    //             // series2.push(res.total)
    //         }).catch(err => {
    //         })
    //     }

    // },


    runLlineCanva: function () {
        const db = wx.cloud.database()

        console.log(series1)
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

                series1[index] = { name: this.data.tags[i], data: res.total };
                // series1.push({ name: this.data.tags[i], data: res.total })
                ++index;

                // series2.push(res.total)
            }).catch(err => {
            })
        }
        console.log(series1)
        let windowWidth = 320;
        try {
            let res = wx.getSystemInfoSync();
            windowWidth = res.windowWidth;
        } catch (e) {
            // do something when get system info failed
        }

        let i = 2

        // ['Java', 'C/C++', 'Python', 'C#', 'Go', 'PHP', 'Shell', '算法', 'Vue'],
        // console.log(series1)
        new Charts({
            canvasId: 'canvas1',
            type: 'pie',
            series: [
                { name: "Java", data: i },
                { name: 'C/C++', data: i + 1 },
                { name: 'Python', data: i + 2 },
                { name: 'C#', data: i + 3 },
                { name: 'Go', data: i + 4 },
                { name: 'PHP', data: i + 5 },
                { name: 'Shell', data: i + 6 },
                { name: '算法', data: i + 7 },
                { name: 'Vue', data: i + 8 }
            ],
            width: windowWidth - 10,
            height: windowWidth - 20,
            dataLabel: true,
        });
        new Charts({
            canvasId: 'canvas2',
            type: 'column',
            categories: this.data.tags,
            series: [{
                name: '成交量1',
                data: [2, 2, 3, 4, 4, 5, 6, 7, 9]
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