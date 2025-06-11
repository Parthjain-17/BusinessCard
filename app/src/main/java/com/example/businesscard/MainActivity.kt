package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF121212) // dark gray
                ) {
                    InitialPage(
                        name = "Parth Jain",
                        skill = "Android Developer",
                        summary = "Passionate about crafting elegant Android apps using Jetpack Compose.",
                        motto = "Code. Build. Improve.",
                        skills = listOf("Kotlin", "Jetpack Compose", "Git"),
                        phone = "2103293873",
                        email = "hello@gmail.com",
                        linkedin = "www.linkedin.com"
                    )
                }
            }
        }
    }
}

@Composable
fun InitialPage(
    name: String,
    skill: String,
    summary: String,
    motto: String,
    skills: List<String>,
    phone: String,
    email: String,
    linkedin: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        val image = painterResource(R.drawable.profilepic)
        Image(
            painter = image,
            contentDescription = "profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(130.dp)
                .clip(CircleShape)
        )

        UpperText(name = name, skill = skill)
        SummaryText(summary = summary)
        MottoText(motto = motto)
        SkillsSection(skills = skills)

        Spacer(modifier = Modifier.height(60.dp))

        LowerText(phone = phone, email = email, linkedin = linkedin)
    }
}

@Composable
fun UpperText(name: String, skill: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = name,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(top = 15.dp)
        )
        Text(
            text = skill,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFFB0BEC5),
            modifier = modifier
        )
    }
}

@Composable
fun SummaryText(summary: String, modifier: Modifier = Modifier) {
    Text(
        text = summary,
        fontSize = 13.sp,
        color = Color(0xFFB0BEC5),
        textAlign = TextAlign.Center,
        modifier = modifier.padding(vertical = 6.dp)
    )
}

@Composable
fun MottoText(motto: String, modifier: Modifier = Modifier) {
    Text(
        text = "\"$motto\"",
        fontStyle = FontStyle.Italic,
        color = Color(0xFF78909C),
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        modifier = modifier.padding(vertical = 6.dp)
    )
}

@Composable
fun SkillsSection(skills: List<String>) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 12.dp)
    ) {
        skills.forEach {
            Surface(
                color = Color(0xFF263238),
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 2.dp
            ) {
                Text(
                    text = it,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun ContactInfo(print: String, icon: @Composable () -> Unit, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(vertical = 4.dp)
    ) {
        icon()
        Text(
            text = print,
            color = Color.White,
            modifier = Modifier.padding(start = 8.dp),
            fontSize = 14.sp
        )
    }
}

@Composable
fun LowerText(phone: String, email: String, linkedin: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        ContactInfo(
            print = phone,
            icon = { Icon(Icons.Filled.Phone, contentDescription = "Phone", tint = Color.White) },
            modifier = modifier
        )
        ContactInfo(
            print = email,
            icon = { Icon(Icons.Filled.Email, contentDescription = "Email", tint = Color.White) },
            modifier = modifier
        )
        ContactInfo(
            print = linkedin,
            icon = { Icon(Icons.Filled.AccountBox, contentDescription = "LinkedIn", tint = Color.White) },
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LandingPagePreview() {
    BusinessCardTheme {
        InitialPage(
            name = "Parth Jain",
            skill = "Android Developer",
            summary = "Passionate about crafting elegant Android apps using Jetpack Compose.",
            motto = "Code. Build. Improve.",
            skills = listOf("Kotlin", "Jetpack Compose", "Git"),
            phone = "2103293873",
            email = "hello@gmail.com",
            linkedin = "www.linkedin.com"
        )
    }
}
