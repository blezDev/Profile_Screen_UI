package com.blez.profilescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage
import com.blez.profilescreen.ui.theme.ProfileScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileScreenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp)
            .verticalScroll(scrollState)
            .background(Color(0xFF0D1417))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 10.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {

                Spacer(modifier = Modifier.width(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Profile Screen",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier,
                contentAlignment = Alignment.Center
            ) {
                SubcomposeAsyncImage(
                    model = R.drawable.profile_background
                        ?: "https://img.freepik.com/free-vector/illustration-businessman_53876-5856.jpg?w=1060&t=st=1706636886~exp=1706637486~hmac=cd845268ac16219ea6e0c908a80c08b399419c0233e51a6eb97022e7ef0167d3",
                    contentDescription = "Latest Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(130.dp)
                        .clip(CircleShape)
                        .shadow(10.dp),
                    loading = { CircularProgressIndicator() },
                    error = {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "Error in Image Loading"
                        )
                    },
                )
                SubcomposeAsyncImage(
                    model = R.drawable.image
                        ?: "https://img.freepik.com/free-vector/illustration-businessman_53876-5856.jpg?w=1060&t=st=1706636886~exp=1706637486~hmac=cd845268ac16219ea6e0c908a80c08b399419c0233e51a6eb97022e7ef0167d3",
                    contentDescription = "Latest Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(119.dp)
                        .clip(CircleShape)
                        .shadow(10.dp)
                        .clickable {

                        },
                    loading = { CircularProgressIndicator() },
                    error = {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "Error in Image Loading"
                        )
                    },
                )
            }

        }
        Spacer(modifier = Modifier.height(50.dp))

        LowerProfileSection(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                .weight(0.5f)
        )

    }
}


@Composable
fun LowerProfileSection(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("M Saikrishna Pattnaik") }
    var companyName by remember { mutableStateOf("ABC Company") }
    var emailAddress by remember { mutableStateOf("XYZ@gmail.com") }
    var phoneNumber by remember { mutableStateOf("+91 -xxxxxxxxxx") }
    Column(
        modifier = modifier

            .background(Color(0xFF0D1417))
            .padding(30.dp),

        ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Name",
            fontSize = 14.sp,
            color = Color(0xFFABABAB),
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(R.font.montserrat_regular))
        )
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            value = name,
            onValueChange = { name = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                errorLeadingIconColor = Color.Red,
                errorTrailingIconColor = Color.Red,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White
            ),
            // label = { Text("Name") }, // Floating label
            // Placeholder inside the field
            //leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Person Icon") }, // Optional leading icon
            //trailingIcon = { Icon(Icons.Default.Clear, contentDescription = "Clear Icon") }, // Optional trailing icon
            singleLine = true, // Set to true for a single-line input
            modifier = modifier
                .fillMaxWidth(), // Add padding and full-width
            textStyle = TextStyle(fontFamily = FontFamily(Font(R.font.montserrat_regular)))


        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Company Name",
            fontSize = 14.sp,
            color = Color(0xFFABABAB),
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(R.font.montserrat_regular))
        )
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            value = companyName,
            onValueChange = { companyName = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                errorLeadingIconColor = Color.Red,
                errorTrailingIconColor = Color.Red,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White
            ),
            // label = { Text("Name") }, // Floating label
            // Placeholder inside the field
            //leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Person Icon") }, // Optional leading icon
            //trailingIcon = { Icon(Icons.Default.Clear, contentDescription = "Clear Icon") }, // Optional trailing icon
            singleLine = true, // Set to true for a single-line input
            modifier = modifier
                .fillMaxWidth(),// Add padding and full-width
            textStyle = TextStyle(fontFamily = FontFamily(Font(R.font.montserrat_regular)))
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Email Address",
            fontSize = 14.sp,
            color = Color(0xFFABABAB),
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(R.font.montserrat_regular))
        )
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            value = emailAddress,
            onValueChange = { emailAddress = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                errorLeadingIconColor = Color.Red,
                errorTrailingIconColor = Color.Red,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White
            ),
            // label = { Text("Name") }, // Floating label
            // Placeholder inside the field
            //leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Person Icon") }, // Optional leading icon
            //trailingIcon = { Icon(Icons.Default.Clear, contentDescription = "Clear Icon") }, // Optional trailing icon
            singleLine = true, // Set to true for a single-line input
            modifier = modifier
                .fillMaxWidth(),// Add padding and full-width
            textStyle = TextStyle(fontFamily = FontFamily(Font(R.font.montserrat_regular)))
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Phone Number",
            fontSize = 14.sp,
            color = Color(0xFFABABAB),
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(R.font.montserrat_regular))
        )
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                errorLeadingIconColor = Color.Red,
                errorTrailingIconColor = Color.Red,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White
            ),
            // label = { Text("Name") }, // Floating label
            // Placeholder inside the field
            //leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Person Icon") }, // Optional leading icon
            //trailingIcon = { Icon(Icons.Default.Clear, contentDescription = "Clear Icon") }, // Optional trailing icon
            singleLine = true, // Set to true for a single-line input
            modifier = modifier
                .fillMaxWidth(),// Add padding and full-width
            textStyle = TextStyle(fontFamily = FontFamily(Font(R.font.montserrat_regular)))
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            onClick = {


            }) {
            Text(
                text = "Save Changes".capitalize(Locale.current),
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp),
                color = Color.White, fontFamily = FontFamily(Font(R.font.montserrat_regular))
            )
        }

    }
}