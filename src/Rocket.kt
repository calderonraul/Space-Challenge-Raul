open class Rocket(
    var cost:Int, var Weight:Int,
    var MaxWeight:Int, var ChancesOfLaunchExplosion: Double,
    var ChancesOfLandingExplosion: Double,
    var currentWeight:Int ) : SpaceShip {
    override fun launch(): Boolean {
        return true
    }

    override fun land(): Boolean {
        return true
    }

    override fun canCarry(item: Item): Boolean {
        return currentWeight + item.weight <=MaxWeight
    }

    override fun carry(item: Item): Int {
        currentWeight+=item.weight
        return currentWeight
    }

}