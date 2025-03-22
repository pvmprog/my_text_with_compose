package com.pvmprog.mytextwithcompose.ui.service.tranlate_new

import com.pvmprog.mytextwithcompose.ui.service.tranlate_new.DataTranslate.listKeyWords
import com.pvmprog.mytextwithcompose.ui.service.tranlate_new.DataTranslate.listWhile

fun annotationKotlin(
    code:String = ""
):List<ItemFromCode> {
    val itemsCode : MutableList<ItemFromCode> = mutableListOf()
    var startInd:Int
    var endInd:Int
    var strVal:String
    var str = ""
    val endKey = "\n"


    var codeStr = code

    fun find_hex(idColor: Int = 1) {
        //Поиск   0x00 ...
        endInd = 0
        do {
            var ind = codeStr.indexOf("0x", endInd)
            if (ind != -1) {
                startInd = ind
                ind = ind + 2
                var isErr = true
                do {
                    ind++
                    val d = codeStr[ind].uppercase().hashCode()
                    val isHex = d in 'A'.hashCode()..'F'.hashCode()
                    if (codeStr[ind].isDigit() || (isHex)) {
                        isErr = false
                        continue
                    } else break
                } while (ind < codeStr.length - 1)
                endInd = ind
                if (!isErr) {
                    strVal = codeStr.substring(startInd, endInd)
//                    println("hex: $strVal $idColor")
                    itemsCode.add(ItemFromCode(startInd, endInd, idColor, strVal))
                    codeStr =
                        codeStr.replaceRange(startInd, endInd, (" ").repeat(endInd - startInd))

                }
            }
        } while (ind >= 0)
    }


    fun find_number(idColor: Int = 1) {
        //Поиск  чисел 0..9
        for (i in 0..9) {
            var ind: Int
            endInd = 0
            do {
                str = i.toString()
                ind = codeStr.indexOf(str, endInd)
                if (ind != -1) {
                    //поиск предстоящих чисел
                    startInd = ind
                    endInd = ind
                    var isNotName = false
                    do {
                        ind--
                        if (codeStr[ind].isDigit()) startInd = ind
                        else {
                            if ((codeStr[ind] == '=') || (codeStr[ind] == ' ') || (codeStr[ind] == '(')) isNotName =
                                true
                            ind = -1
                        }
                    } while (ind >= 0)

                    //поиск следующих чисел
                    ind = endInd
                    do {
                        ind++
                        if (codeStr[ind].isDigit()) endInd = ind
                        else {
                            if (codeStr[ind] == 'f') {
                                endInd = ind
                                break
                            }

                            if (codeStr[ind] == '.') {
                                do {
                                    ind ++
                                    if (codeStr[ind].isDigit()) endInd = ind
                                    else {
                                        if (codeStr[ind] == 'f') endInd = ind
                                        ind = -1
                                    }
                                } while (ind >= 0)

                            }

                            ind = -1
                        }

                    } while (ind >= 0)

                    endInd++

                    strVal = codeStr.substring(startInd, endInd)
                    if (isNotName) {
                        itemsCode.add(ItemFromCode(startInd, endInd, idColor, strVal, false))
                        codeStr = codeStr.replaceRange(startInd, endInd, (" ").repeat(endInd - startInd))
                    }
                    ind = 0
                    endInd ++
                }

            } while (ind >= 0)

        }
    }

    fun find_multi_line_comment(idColor:Int = 0){
        endInd = 0
        do {
            str = "/*"
            var ind = codeStr.indexOf(str,endInd)
            if (ind != -1) {
                startInd = ind
                str = "*/"
                ind = codeStr.indexOf(str,startInd)
                if (ind != -1) {
                    endInd = ind + 2
                    strVal = codeStr.substring(startInd,endInd)
                    itemsCode.add(ItemFromCode(startInd,endInd,idColor,strVal))
                    codeStr = codeStr.replaceRange(startInd,endInd,(" ").repeat(endInd-startInd))
                }
            }


        } while(ind >= 0)

    }

    //Все, что внутри " "
    fun find_str_value(idColor1:Int = 2,idColor2:Int = 7,idColor3:Int = 10){
        endInd = 0
        do {
            val ch = '"'
            var ind = codeStr.indexOf(ch,endInd)
            if (ind != -1) {
                startInd = ind
                ind = codeStr.indexOf(ch,startInd+1)
                if (ind != -1) {
                    endInd = ind + 1
                    strVal = codeStr.substring(startInd,endInd)
                    itemsCode.add(ItemFromCode(startInd,endInd,idColor1,strVal))
                    codeStr = codeStr.replaceRange(startInd,endInd,(" ").repeat(endInd-startInd))
                    ind = -1
                    do {
                        ind ++
                        ind = strVal.indexOf('$',ind)
                        if (ind != -1) {
                            var st = startInd + ind
                            itemsCode.add(ItemFromCode(st,st + 1,idColor2,"$"))
                            ind ++
                             //поиск названия переменной в { }
                            if (strVal[ind] == '{'){
                                ind ++
                                val indend = strVal.indexOf('}',ind)
                                if (indend != -1) {
                                    val subStr = strVal.substring(ind,indend)
                                    itemsCode.add(ItemFromCode(startInd + ind,startInd + indend,idColor3,subStr))
                                    ind = indend +1
                                }
                            } else{
                                //поиск названия переменной без { }
                                var isStart = false
                                val len = strVal.length
                                st = ind

                                do {
                                    if (strVal[ind].isLetterOrDigit()) {
                                        isStart = true
                                    } else {
                                        if (isStart) {
                                            val subStr = strVal.substring(st, ind)
                                            itemsCode.add(
                                                ItemFromCode(
                                                    startInd + st,
                                                    startInd + ind,
                                                    idColor3,
                                                    subStr
                                                )
                                            )
                                        }
                                        break
                                    }
                                    ind++
                                } while (ind <= len)

                            }
                        }
                    } while ( ind >= 0)
//поиск \n
                    ind = -1
                    val transfer = "\\n"
                    do {
                        ind++
                        ind = strVal.indexOf(transfer, ind)
                        if (ind != -1) {
                            val st = startInd + ind
                            itemsCode.add(ItemFromCode(st, st + 2, idColor2, transfer))
                            ind++
                        }
                    } while ( ind >= 0)
                    ind = 0


                }
            }


        } while(ind >= 0)

    }


    fun one_line_comment(idColor:Int = 0){
        endInd = 0
        do {
            var ind = codeStr.indexOf("//",endInd)
            if (ind != -1) {
                startInd = ind
                ind = codeStr.indexOf(endKey,startInd)
                if (ind != -1) {
                    endInd = ind
                    strVal = codeStr.substring(startInd,endInd)
//                    println(strVal)
                    itemsCode.add(ItemFromCode(startInd,ind,idColor,strVal))
                    codeStr = codeStr.replaceRange(startInd,endInd,(" ").repeat(endInd-startInd))
                }
            }

        } while(ind >= 0)

    }

    //Все от val до "=" включительно очищаем
    fun delete_name_variables(keyword:String = "val "){
        endInd = 0
        do {
            var ind = codeStr.indexOf(keyword,endInd)
            if (ind != -1) {
                ind = ind + 3
                startInd = ind
                endInd = ind
                //  определение названия переменной names
                var isStart = false
                do{
                    ind ++
                    if (codeStr[ind].isLetterOrDigit()) {
                        if (!isStart) startInd = ind
                        isStart = true
                    }
                    else if (isStart) break
                } while (ind < codeStr.length)
                endInd = ind
                strVal = codeStr.substring(startInd,endInd)
                //очищаем название переменной
                codeStr = codeStr.replaceRange(startInd,endInd,(" ").repeat(endInd-startInd))

                //ищем = и очищаем его
                ind = codeStr.indexOf('=',endInd)
                if (ind != -1) {
                    endInd = ind + 1
                    strVal = codeStr.substring(startInd,endInd)
                    var n = strVal.indexOf("\n")
                    if (n == -1){
                        println("clr name_variable:  $strVal")
//                       codeStr = codeStr.replaceRange(startInd,endInd,(" ").repeat(endInd-startInd))
                        n = endInd - 1
                        codeStr = codeStr.replaceRange(n,endInd," ")
                    } else{
                        endInd = startInd + n
                    }
                }
            }

        } while(ind >= 0)

    }




    fun find_param(idColor:Int = 3){
        endInd = 0
        var ind:Int
        do {
            ind = codeStr.indexOf('=',endInd)
            if (ind != -1) {
                endInd = ind + 1
                startInd = ind
                //поиск предстоящих символов
                var k_space = 0
                do{
                    ind --
                    startInd = ind
                    if (!codeStr[ind].isLetterOrDigit()) {
                        if (k_space == 0) continue
                        else break
                    }
                    else {
                        k_space = 1
                    }
                } while (ind > 0)

                startInd ++
                strVal = codeStr.substring(startInd,endInd)
//                println("param : $strVal")
                itemsCode.add(ItemFromCode(startInd,endInd,idColor,strVal))
                codeStr = codeStr.replaceRange(startInd,endInd,(" ").repeat(endInd-startInd))
            }

        } while(ind >= 0)

    }

//Ограничение:
// Между названием функции и ( не должно быть пробела
    fun find_fun(idColor1:Int = 4,idColor2:Int = 5,idColor3:Int = 10,idColor4:Int = 11){
        endInd = 0
        do {
            var ind = codeStr.indexOf('(',endInd)
            if (ind != -1) {
                endInd = ind + 1
                startInd = ind
                //поиск предстоящих символов
                var isName = false
                do{
                    ind --

                    if (codeStr[ind].isLetter()) {
                        startInd = ind
                        isName = true
                    }
                    else break


                } while (ind > 0)

                if (isName){
                    val start = startInd - 4
                    val isNameMyFun = if (start >= 0){
                        if (codeStr.substring(start,start+4) == "fun ") true
                        else false
                    } else false


                    endInd --
                    if (startInd < endInd){
                        strVal = codeStr.substring(startInd,endInd)

                        var idColor = if (strVal[0].isUpperCase()) idColor1
                        else idColor2

                        listWhile.forEach(){
                            if (strVal == it) idColor = idColor3 //белый цвет
                        }

                        if (isNameMyFun) idColor = idColor4

                        println("fun: $strVal $idColor")
                        itemsCode.add(ItemFromCode(startInd,endInd,idColor,strVal))
                        codeStr = codeStr.replaceRange(startInd,endInd,(" ").repeat(endInd-startInd))

                    }

                } else endInd ++
                endInd ++
            }

        } while(ind >= 0)

    }


    //idColor1 .name  idColor2 .name.
    fun find_property(idColor1:Int = 6,idColor2:Int = 4,idColor3:Int = 10){
        endInd = 0
        var idColor:Int
        var ind:Int
        do {
            ind = codeStr.indexOf('.',endInd)
            if (ind != -1) {
                val isRes = codeStr[ind-1] == 'R'
                endInd = ind + 1
                startInd = ind
                //поиск следующих символов
                do{
                    ind ++
                    if (codeStr[ind] == 'W'){
                        endInd = ind
                    }
                    endInd = ind
                    idColor = idColor1
                    if (codeStr[ind] == '.') {
                        idColor = if (isRes) idColor3
                        else idColor2
                        break
                    }

                    if (codeStr[ind] != '_'){
                        if (codeStr[ind] == ' ') break
                        if (codeStr[ind] == ',') break
                        if (!codeStr[ind].isLetterOrDigit()) break
                    }
                } while (ind < codeStr.length-1)

                startInd ++
                strVal = codeStr.substring(startInd,endInd)
                if (startInd<endInd){
//                    println("property: $strVal $idColor")
                    itemsCode.add(ItemFromCode(startInd,endInd,idColor,strVal))
                }
                codeStr = codeStr.replaceRange(startInd,endInd,(" ").repeat(endInd-startInd))
                if (codeStr[ind] != '.') endInd ++
            }

        } while(ind >= 0)

    }

    fun find_keywords(
        listKeyWords:List<HighlightColor>
    ){
        listKeyWords.forEach(){
            val keyword = it.subStr
            val idColor = it.idColor
            endInd = 0
            if (!str.isBlank()){
                do{
                    val ind = codeStr.indexOf(keyword,endInd)
                    if (ind != -1) {
                        startInd = ind
                        endInd = ind + keyword.length
                        strVal = codeStr.substring(startInd,endInd)
//                        println("KeyWords: $strVal $idColor")
                        itemsCode.add(ItemFromCode(startInd,endInd,idColor,strVal,false))
                        codeStr = codeStr.replaceRange(startInd,endInd,(" ").repeat(endInd-startInd))
                    }

                } while((ind>=0))

            }

        }

    }


//Поиск   /*   */
//    println("Поиск  многострочных комментарий  color=0")
    find_multi_line_comment(0)

//    println("Поиск  //...  color=0")
    one_line_comment(0)

//Поиск "  ...  "
//    println("Поиск значения строки color=2")
    find_str_value(2)

//    println("Поиск hex ")
    find_hex(1)

//    println("Удаление (val/var) названий переменных")
    delete_name_variables("val ")
    delete_name_variables("var ")

//    println("Поиск чисел 1 2 ... color=1")
    find_number(1)

//    println("Поиск параметров функции color=3")
    find_param(3)

//    println("Поиск функции color=4,5 ")
    find_fun(4,5)

//    println("Поиск свойства color=6,4")
    find_property(6,4)

//    println("Поиск keywords: val var if ... color=...")
    find_keywords(listKeyWords)

    return itemsCode

}
