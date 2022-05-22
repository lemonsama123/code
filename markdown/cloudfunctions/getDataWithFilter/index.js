// 云函数入口文件
const cloud = require('wx-server-sdk')

cloud.init({
    env: cloud.DYNAMIC_CURRENT_ENV
})

const db = cloud.database()
const _ = db.command

// 云函数入口函数
exports.main = async (event, context) => {
    console.log(event)
    try {
        return db.collection('docs').where({
            tag: event._key
        }).get()
    } catch (e) {
        console.log(e)
    }
}