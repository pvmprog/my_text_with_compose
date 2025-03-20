package com.pvmprog.mytextwithcompose.ui.service.tranlate_new

import com.pvmprog.mytextwithcompose.ui.service.tranlate_new.DataTranslate.listKeyWords
import com.pvmprog.mytextwithcompose.ui.service.tranlate_new.DataTranslate.listWhile

fun translationCode(
    code:String = "",
    names:List<HighlightColor> = listOf()
):List<ItemFromCode> {
    val itemsCode : MutableList<ItemFromCode> = mutableListOf()
    var startInd:Int
    var endInd:Int
    var strVal:String
    var str = ""
    val endKey = "\n"


    var codeStr = code

    fun find_number(idColor:Int = 1) {
        //Поиск  чисел 0..9
        for(i in 0..9){
            var ind:Int
            endInd = 0
            do {
                str = i.toString()
                ind = codeStr.indexOf(str,endInd)
                if (ind != -1) {
                    //поиск предстоящих чисел
                    startInd = ind
                    endInd = ind
                    var isNotName = false
                    do{
                        ind --
                        if (codeStr[ind].isDigit()) startInd = ind
                        else {
                            if ((codeStr[ind] == '=')||(codeStr[ind] == ' ')||(codeStr[ind] == '(')) isNotName = true
                            ind = -1
                        }
                    } while (ind>=0)

                    //поиск следующих чисел
                    ind = endInd
                    do{
                        ind ++
                        if (codeStr[ind].isDigit()) endInd = ind
                        else {
                            if (codeStr[ind]=='f') {
                                endInd = ind
                                break
                            }

                            if (codeStr[ind]=='.'){
                                do {
                                    ind ++
                                    if (codeStr[ind].isDigit()) endInd = ind
                                    else {
                                        if (codeStr[ind]=='f') endInd = ind
                                        ind = -1
                                    }
                                } while (ind >= 0)

                            }
                            ind = -1
                        }

                    } while(ind>=0)

                    endInd ++

                    strVal = codeStr.substring(startInd,endInd)
                    if (isNotName) itemsCode.add(ItemFromCode(startInd,endInd,idColor,strVal,false))
//                    println(strVal)
                    codeStr = codeStr.replaceRange(startInd,endInd,(" ").repeat(endInd-startInd))
                    ind = 0
                }

            } while(ind >= 0)

        }
    }

    fun find_multycom(idColor:Int = 0){
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
    fun find_str_value(idColor:Int = 2){
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
//                    println("Все, что внутри \" \" : $strVal  $idColor")
                    itemsCode.add(ItemFromCode(startInd,endInd,idColor,strVal))
                    codeStr = codeStr.replaceRange(startInd,endInd,(" ").repeat(endInd-startInd))
                }
            }


        } while(ind >= 0)

    }


    fun find_com(idColor:Int = 0){
        endInd = 0
        do {
            str = "//"
            var ind = codeStr.indexOf(str,endInd)
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
                startInd = ind + 3
                endInd = startInd
                ind = codeStr.indexOf('=',endInd)
                if (ind != -1) {
                    endInd = ind + 1
                    strVal = codeStr.substring(startInd,endInd)
//                    println("clr name_variable:  $strVal")
                    codeStr = codeStr.replaceRange(startInd,endInd,(" ").repeat(endInd-startInd))
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
                    if (!codeStr[ind].isLetter()) {
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

    fun find_fun(idColor1:Int = 4,idColor2:Int = 5,idColor3:Int = 10){
        endInd = 0
        do {
            var ind = codeStr.indexOf('(',endInd)
            if (ind != -1) {
                endInd = ind + 1
                startInd = ind
                //поиск предстоящих символов
                var k_space = 0
                do{
                    ind --
                    startInd = ind
                    if (ind == -1) {
                        ind = 0
                        break
                    }

                    if (!codeStr[ind].isLetter()) {
                        if (k_space == 0) continue
                        else break
                    }
                    else {
                        k_space = 1
                    }
                } while (ind>=0)
                startInd ++
                endInd --
                if (startInd < endInd){
                    strVal = codeStr.substring(startInd,endInd)
                    if (strVal.substring(0,3) !="fun"){
                        var idColor = if (strVal[0].isUpperCase()) idColor1
                        else idColor2
                        listWhile.forEach(){
                            if (strVal == it) idColor = idColor3 //белый цвет
                        }
                        println("fun: $strVal $idColor")
                        itemsCode.add(ItemFromCode(startInd,endInd,idColor,strVal))
                        codeStr = codeStr.replaceRange(startInd,endInd,(" ").repeat(endInd-startInd))

                    }

                }
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
                val isRes = if (codeStr[ind-1] == 'R') true
                else false
                endInd = ind + 1
                startInd = ind
                //поиск следующих символов
                do{
                    ind ++
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
                        if (!codeStr[ind].isLetter()) break
                    }
                } while (ind > 0)

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
    find_multycom(0)

//    println("Поиск  //...  color=0")
    find_com(0)

//Поиск "  ...  "
//    println("Поиск значения строки color=2")
    find_str_value(2)

//    println("Поиск my name")
    find_keywords(names)


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
