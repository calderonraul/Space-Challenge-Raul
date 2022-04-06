class U2(
    cost: Int = 120,
    Weight: Int=18000,
    MaxWeight: Int= 29000,
    ChancesOfLaunchExplosion: Double=0.0,
    ChancesOfLandingExplosion: Double=0.0,
    currentWeight: Int = Weight
) : Rocket(cost, Weight, MaxWeight, ChancesOfLaunchExplosion, ChancesOfLandingExplosion, currentWeight) {

    var random =0

    override fun launch(): Boolean {
        random=(Math.random()*100+1).toInt()
        ChancesOfLaunchExplosion=4.0*(currentWeight-Weight)/(MaxWeight-Weight)

        return ChancesOfLaunchExplosion <= random
    }

    override fun land(): Boolean {
        random=(Math.random()*100+1).toInt()
        ChancesOfLandingExplosion=8.0*(currentWeight-Weight)/(MaxWeight-Weight)

        return ChancesOfLandingExplosion <=random
    }


}