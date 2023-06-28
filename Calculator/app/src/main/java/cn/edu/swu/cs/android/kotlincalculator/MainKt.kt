package cn.edu.swu.cs.android.kotlincalculator

import kotlin.system.exitProcess

/**
 * 枚举类：定义计算符号
 */
enum class Operation(val value: String) {
    ADD("+"),
    MINUS("-"),
    MULTI("*"),
    DIVI("/");
}
/**
 * 定义计算公式实体类
 */
data class Expression(
    val left: String,
    val operator: Operation,
    val right: String
)
/**
 * 计算器类
 */
class Calculator {
    //退出指令
    private val EXIT = "exit"

    //帮助信息
    private val HELP = """
-------------------------------------
使用说明：
1. 输入 1 + 1，按回车，即可使用计算器；
2. 主要：数字与符号之间要有空格；
3. 想要退出程序，请输入：exit；
-------------------------------------
""".trimIndent()

    //开始运行计算器
    fun start() {
        while (true) {
            println(HELP)

            val input = readLine() ?: continue

            val result = calculate(input)

            if (result == null) {
                println("输入格式不正确")
                continue
            } else {
                println("$input = $result")
            }
        }
    }

    /**
     * 计算公式
     */
    private fun calculate(input: String): String? {
        if (shouldExit(input)) exitProcess(0)

        val exp = parseExpression(input) ?: return null

        val (left, operator, right) = exp

        return when (operator) {
            Operation.ADD -> add(left, right)
            Operation.MINUS -> minus(left, right)
            Operation.MULTI -> multi(left, right)
            Operation.DIVI -> divi(left, right)
        }
    }


    /**
     * 是否必须退出
     */
    private fun shouldExit(input: String): Boolean {
        return input == EXIT
    }

    /**
     * 解析计算公式
     */
    private fun parseExpression(input: String): Expression? {
        val operator = parseOperation(input) ?: return null

        val list = input.split(operator.value)
        if (list.size != 2) return null

        return Expression(left = list[0].trim(), operator = operator, right = list[1].trim())
    }

    /**
     * 解析出计算符号
     */
    private fun parseOperation(input: String): Operation? {
        Operation.values().forEach {
            if (input.contains(it.value)) {
                return it
            }
        }
        return null
    }

    /**
     * 加
     */
    fun add(left: String, right: String): String {
        return (left.toLong() + right.toLong()).toString()
    }

    /**
     * 减
     */
    fun minus(left: String, right: String): String {
        return (left.toLong() - right.toLong()).toString()
    }

    /**
     * 乘
     */
    fun multi(left: String, right: String): String {
        return (left.toLong() * right.toLong()).toString()
    }

    /**
     * 除
     */
    fun divi(left: String, right: String): String {
        return (left.toLong() / right.toLong()).toString()
    }
}
fun main() {
    val calculator = Calculator()
    calculator.start()
}