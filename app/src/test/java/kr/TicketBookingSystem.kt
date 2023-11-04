package kr


data class Show(
    val showId: String,
    val name: String,
    val date: String,
    val capacity: Int,
    var bookedTickets: Int
)

data class Ticket(
    val showId: String,
    val seatNumber: Int
)

class TicketBookingSystem(private val shows: MutableList<Show>) {

    fun bookTickets(showId: String, numTickets: Int): List<Ticket>? {
        val show = getShowById(showId)
        if (show != null && show.capacity >= show.bookedTickets + numTickets) {
            show.bookedTickets += numTickets
            val tickets = mutableListOf<Ticket>()
            repeat(numTickets) {
                tickets.add(Ticket(showId, it + 1))
            }
            return tickets
        }
        return null
    }

    fun checkAvailability(showId: String): Int {
        val show = getShowById(showId)
        return show?.let { it.capacity - it.bookedTickets } ?: -1
    }

    private fun getShowById(showId: String): Show? {
        return shows.find { it.showId == showId }
    }
}

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