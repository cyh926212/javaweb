package cn.edu.swu.cs.android.todolist

data class Todo(var content: String,
                var createTime: Long, var title:String) {
    companion object {
        val TABLE = "Todo"
        val COL_ID = "id"
        val COL_CONTENT = "content"
        val COL_TIME = "createTime"
        val COL_TITLE="title"
    }

    var id: Int? = null
}