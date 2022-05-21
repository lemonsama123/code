// pages/add/add.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        cover: '',
        title: '',
        url: '',
        author: '',
        date: '2016-09-01',
        tag: 'Java',
        summary: '',
        tags: ['Java', 'C++'],
        datas: [
            [1950, 1951, 1952, 1953, 1954, 1955, 1956, 1957, 1958, 1959, 1960, 1961, 1962, 1963, 1964, 1965, 1966, 1967, 1968, 1969, 1970, 1971, 1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1980, 1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024],
            [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12],
            [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31]
        ],
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad(options) {
    },

    bindAuthorChange(e) {
        this.setData({
            tag: this.data.tags[e.detail.value],
        })
    },

    bindDateChange(e) {
        this.setData({
            date: e.detail.value,
        });
    },

    bindKeyInput(e) {
        if (e.target.dataset.type === 1) {
            // console.log(e)
            this.setData({
                title: e.detail.value
            })

        } else if (e.target.dataset.type === 2) {
            this.setData({
                url: e.detail.value
            })
        } else if (e.target.dataset.type === 3) {
            this.setData({
                summary: e.detail.value
            })
        } else if (e.target.dataset.type === 4) {
            this.setData({
                author: e.detail.value
            })
        }

    },

    //上传文件
    chooseFile(e) {
        console.log(e.target.dataset.type)
        let that = this
        wx.chooseMessageFile({
            count: 1,
            type: 'all',
            success(res) {
                const tempFilePaths = res.tempFiles
                let tempFile = tempFilePaths[0]
                that.uploadFile(tempFile.name, tempFile.path, e.target.dataset.type)
            }
        })
    },

    uploadFile(fileName, tempFile, type) {
        wx.cloud.uploadFile({
            cloudPath: 'docs/' + fileName,
            filePath: tempFile,
        }).then(res => {
            console.log("上传成功啦", res);
            wx.showToast({
                title: '文件上传成功',
                icon: "success",
                duration: 2000
            })
            console.log(res.fileID)
            wx.cloud.getTempFileURL({
                fileList: [{
                    fileID: res.fileID,
                    maxAge: 60 * 60
                }]
            }).then(res => {
                console.log("teste1232")
                console.log(res.fileList[0].tempFileURL)
                console.log(type)
                if (type === 2) {
                    this.setData({
                        url: res.fileList[0].tempFileURL
                    })
                } else if (type === 1) {
                    this.setData({
                        cover: res.fileList[0].tempFileURL
                    })
                }
            })
        }).catch(err => {
            console.log("上传失败啦", err);
        })
    },

    submit() {
        wx.cloud.callFunction({
            name: 'add',
            data: {
                cover: this.data.cover,
                title: this.data.title,
                url: this.data.url,
                author: this.data.author,
                date: this.data.date,
                tag: this.data.tag,
                summary: this.data.summary,
            }
        }).then(res => {
            console.log('成功了')
            console.log(res)
        }).catch(err => {
            console.log('失败了')
        })
    },


    // formSubmit(e) {
    //     // console.log(e.detail.value.title)
    //     // console.log(e.detail.value.url)
    //     // wx.cloud.callFunction({
    //     //     name: 'add',
    //     //     data: {
    //     //         title: e.detail.value.title,
    //     //         url: e.detail.value.url
    //     //     }
    //     // }).then(res => {
    //     //     console.log('成功了')
    //     //     console.log(res)
    //     // }).catch(err => {
    //     //     console.log('失败了')
    //     // })

    //     // console.log(e.detail.value.title)
    //     // console.log(e.detail.value.url)
    //     wx.cloud.callFunction({
    //         name: 'add',
    //         data: {
    //             title: e.detail.value.title,
    //             url: this.data._url
    //         }
    //     }).then(res => {
    //         console.log('成功了')
    //         console.log(res)
    //     }).catch(err => {
    //         console.log('失败了')
    //     })
    // },

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