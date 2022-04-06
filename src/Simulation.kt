
import java.io.File
import java.util.*

class Simulation {


    fun loadItems(fileName: String): ArrayList<Item> {
        val file = File(fileName)
        val scan = Scanner(file)
        val items = ArrayList<Item>()
        while (scan.hasNextLine()) {
            val line = scan.nextLine()
            val oneItem = line.split("=".toRegex()).toTypedArray()
            items.add(Item(oneItem[0], oneItem[1].toInt()))
        }

        println(fileName + " contains " + items.size + " items")

        return items
    }


    fun loadU1(list: ArrayList<Item>): ArrayList<Rocket> {
        val fleet = ArrayList<Rocket>()
        var r: Rocket = U1()
        var itemCounter = 1
        var rocketCounter = 1
        println(
            """
    
    U1 Rocket weight = ${r.Weight}; maxWeight = ${r.MaxWeight}
    """.trimIndent()
        )
        for (i in list) {
            while (!r.canCarry(i)) {
                rocketCounter++
                fleet.add(r)
                r = U1()
            }
            r.carry(i)


            itemCounter++
        }
        fleet.add(r)
        println("U1 fleet contains " + fleet.size + " rockets")
        return fleet
    }


    fun loadU2(list: ArrayList<Item>): ArrayList<Rocket> {
        val fleet = ArrayList<Rocket>()
        var r: Rocket = U2()
        var itemCounter = 1
        var rocketCounter = 1
        println("U2 Rocket weight = " + r.Weight.toString() + "; maxWeight = " + r.MaxWeight)
        for (i in list) {
            while (!r.canCarry(i)) {

                rocketCounter++
                fleet.add(r)
                r = U2()
            }
            r.carry(i)

            itemCounter++
        }
        fleet.add(r)
        println(
            """U2 fleet contains ${fleet.size} rockets
"""
        )
        return fleet
    }

    fun runSimulation(list: ArrayList<Rocket>): Int {
        var num = 0 //failed trials of launch/land
        var indexSuccess = 1
        for (r in list) {
            while (!r.launch()) {
                r.launch()
                num++

            }

            while (!r.land()) {
                r.land()
                num++

            }
            indexSuccess++
        }
        val budget = list[0].cost * (list.size + num)
        println(
            list.size.toString() + " rockets and " + num + " extra trials = "
                    + (list.size + num) + " in total"
        )
        return budget
    }


}