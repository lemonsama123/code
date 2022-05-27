// pages/add/add.js
Page({
    data: {
        cover: '',
        title: '',
        url: '',
        author: '',
        date: '2016-09-01',
        tag: 'Java',
        summary: '',
        tags: ['Java', 'C/C++', 'Python', 'C#', 'Go', 'PHP', 'Shell', '算法', 'Vue'],
    },
    onLoad(options) {
    },
    bindTagChange(e) {
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
    chooseFile(e) {
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
            wx.cloud.getTempFileURL({
                fileList: [{
                    fileID: res.fileID,
                    maxAge: 60 * 60
                }]
            }).then(res => {
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
            wx.showToast({
                title: '添加成功',
            })
        }).catch(err => {
        })
    },
})