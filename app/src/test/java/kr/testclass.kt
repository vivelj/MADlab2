package kr

fun main() {
    val shows = mutableListOf(
        Show("1", "Hamlet", "2023-10-15", 100, 0),
        Show("2", "Romeo and Juliet", "2023-10-20", 200, 0)
    )

    val ticketBookingSystem = TicketBookingSystem(shows)

    val reservation1 = ticketBookingSystem.bookTickets("1", 3)
    if (reservation1 != null) {
        println("Tickets booked: $reservation1")
    } else {
        println("Not enough available tickets for Show 1")
    }

    val reservation2 = ticketBookingSystem.bookTickets("2", 5)
    if (reservation2 != null) {
        println("Tickets booked: $reservation2")
    } else {
        println("Not enough available tickets for Show 2")
    }

    val availability1 = ticketBookingSystem.checkAvailability("1")
    println("Available tickets for Show 1: $availability1")

    val availability2 = ticketBookingSystem.checkAvailability("2")
    println("Available tickets for Show 2: $availability2")
}
