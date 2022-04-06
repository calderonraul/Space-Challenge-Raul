
fun main(args: Array<String>) {
    val sim = Simulation()

    // Load Items for Phase-1 and Phase-2
    val phase1 = sim.loadItems("src/phase1.txt")
    val phase2 = sim.loadItems("src/phase2.txt")


    // Load a fleet of U1 rockets for Phase-1 and then for Phase-2
    val u1FleetPhase1 = sim.loadU1(phase1)
    val u1FleetPhase2 = sim.loadU1(phase2)


    // Run the simulation using the fleet of U1 rockets and display the total budget required
    println("\nU1 rocket cost = 100")
    val budgetU1phase1 = sim.runSimulation(u1FleetPhase1)
    println("Budget of U1 fleet for phase 1 = $budgetU1phase1 (millions)")
    val budgetU1phase2 = sim.runSimulation(u1FleetPhase2)
    println("Budget of U1 fleet for phase 2 = $budgetU1phase2 (millions)")
    println(
        """Total budget of U1 fleet = ${budgetU1phase1 + budgetU1phase2} (millions)
"""
    )

    // Repeat the same for U2 rockets and display the total budget for that
    val u2FleetPhase1 = sim.loadU2(phase1)
    val u2FleetPhase2 = sim.loadU2(phase2)
    println("\nU2 rocket cost = 120")
    val budgetU2phase1 = sim.runSimulation(u2FleetPhase1)
    println("Budget of U2 fleet for phase 1 = $budgetU2phase1 (millions)")
    val budgetU2phase2 = sim.runSimulation(u2FleetPhase2)
    println("Budget of U2 fleet for phase 2 = $budgetU2phase2 (millions)")
    println(
        """Total budget of U1 fleet = ${budgetU2phase1 + budgetU2phase2} (millions)
"""
    )
}
