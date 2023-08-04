val context = LocalContext.current
Column() {
    Button(
        onClick = {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            context.startActivity(intent)
        }
    ) {
        Text(text = "2nd_open")
    }
    Button(
        onClick = {
            val intent = Intent(context, thirdActivity::class.java)
            context.startActivity(intent)
        }
    ) {
        Text(text = "3rd_open")
    }
}
