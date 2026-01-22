class MainActivity : AppCompatActivity() {

    private lateinit var reel1: ImageView
    private lateinit var reel2: ImageView
    private lateinit var reel3: ImageView
    private lateinit var coinsText: TextView

    private var coins = 100

    private val symbols = listOf(
        R.drawable.cherry,
        R.drawable.lemon,
        R.drawable.star,
        R.drawable.seven
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reel1 = findViewById(R.id.reel1)
        reel2 = findViewById(R.id.reel2)
        reel3 = findViewById(R.id.reel3)
        coinsText = findViewById(R.id.txtCoins)

        findViewById<Button>(R.id.btnSpin).setOnClickListener {
            spin()
        }
    }

    private fun spin() {
        if (coins <= 0) return

        coins -= 10

        val r1 = symbols.random()
        val r2 = symbols.random()
        val r3 = symbols.random()

        reel1.setImageResource(r1)
        reel2.setImageResource(r2)
        reel3.setImageResource(r3)

        if (r1 == r2 && r2 == r3) {
            coins += 50
            Toast.makeText(this, "JACKPOT 🎉", Toast.LENGTH_SHORT).show()
        }

        coinsText.text = "Coins: $coins"
    }
}
