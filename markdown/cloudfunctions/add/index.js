// 云函数入口文件
const cloud = require('wx-server-sdk')

cloud.init({
    env: cloud.DYNAMIC_CURRENT_ENV
})

const db = cloud.database()
const _ = db.command

// 云函数入口函数
exports.main = async (event, context) => {

    return db.collection('docs').add({
        data: {
            title: event.title,
            url: event.url,
            cover: event.cover,
            title: event.title,
            url: event.url,
            author: event.author,
            date: event.date,
            tag: event.tag,
            summary: event.summary,
        }
    }).then(res => {

    }).catch(err => {

    })

}