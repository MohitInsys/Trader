package com.example.newsjpc.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.newsjpc.ImList
import com.example.newsjpc.ImageModel
import com.example.newsjpc.R
import com.example.newsjpc.ui.theme.NewsJPCTheme

@Composable
fun Home() {

    val iconSearch = painterResource(id = R.drawable.search)
    val ListA = listOf("Headline", "Normal", "New", "Old")
    val ListB = listOf("UI", "Main", "Server", "DataBase")
    val ListC = listOf("Testing", "Automation", "Manual", "Final")
    val ListOfImage = remember { ImList() }
    val ListOfProfile = remember { ProfileList() }


    val iconProfile = painterResource(id = R.drawable.profile)
    Image(painter = painterResource(id = R.drawable.background), contentDescription = null,
        modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(top = 20.dp)
        ) {
            item {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Image(painter = iconSearch, contentDescription = null, modifier = Modifier.padding(start = 10.dp))
                Text(text = "Now In Android", color = Color.Black, fontSize = 22.sp)
                Image(painter = iconProfile, contentDescription = null,modifier=Modifier.padding(end=10.dp))
            }
            }
        item {
            Spacer(modifier = Modifier.height(35.dp))}

        item {
            Text(text = "What are you Interested in?",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)}
        item {
            Text(text = "Updates from topics you follow will appear here.Follow some things to get started",
                modifier = Modifier.padding(1.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Light)}

            item {
            LazyRow(modifier = Modifier.height(105.dp)) {
                items(ListOfProfile) { profile ->
                    ProfileView(profile = profile)

                }
            }}
        item {
            LazyRow {
                items(4) {
                    Column(modifier = Modifier
                        .height(285.dp)
                        .width(320.dp)) {
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .height(95.dp)
                            .padding(horizontal = 20.dp)
                            .padding(vertical = 10.dp),
                            RoundedCornerShape(8.dp),
                            backgroundColor = Color.White) {

                            ConstraintLayout(modifier = Modifier.fillMaxWidth()) {

                                val (image1, Text1, image2) = createRefs()

                                Image(painter = painterResource(id = R.drawable.headl),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .height(35.dp)
                                        .constrainAs(image1) {
                                            top.linkTo(parent.top)
                                            bottom.linkTo(parent.bottom)
                                            start.linkTo(parent.start, margin = 10.dp)
                                        })
                                Text(text = "${ListA[it]}",
                                    modifier = Modifier.constrainAs(Text1) {
                                        top.linkTo(parent.top)
                                        bottom.linkTo(parent.bottom)
                                        start.linkTo(parent.start, margin = 70.dp)
                                    })


                                Image(painter = painterResource(id = R.drawable.add),
                                    contentDescription = "",
                                    modifier = Modifier.constrainAs(image2) {
                                        top.linkTo(parent.top)
                                        bottom.linkTo(parent.bottom)
                                        end.linkTo(parent.end, margin = 15.dp)
                                    })
                            }
                        }


                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .height(95.dp)
                            .padding(vertical = 10.dp)
                            .padding(horizontal = 20.dp),
                            RoundedCornerShape(8.dp),
                            backgroundColor = Color.White) {
                            ConstraintLayout(modifier = Modifier.fillMaxWidth()) {

                                val (image1, Text1, image2) = createRefs()

                                Image(painter = painterResource(id = R.drawable.addnew),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .height(30.dp)
                                        .constrainAs(image1) {
                                            top.linkTo(parent.top)
                                            bottom.linkTo(parent.bottom)
                                            start.linkTo(parent.start, margin = 10.dp)
                                        })
                                Text(text = "${ListB[it]}",
                                    modifier = Modifier.constrainAs(Text1) {
                                        top.linkTo(parent.top)
                                        bottom.linkTo(parent.bottom)
                                        start.linkTo(parent.start, margin = 70.dp)
                                    })


                                Image(painter = painterResource(id = R.drawable.add),
                                    contentDescription = "",
                                    modifier = Modifier.constrainAs(image2) {
                                        top.linkTo(parent.top)
                                        bottom.linkTo(parent.bottom)
                                        end.linkTo(parent.end, margin = 15.dp)
                                    })
                            }
                        }


                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .height(95.dp)
                            .padding(vertical = 10.dp)
                            .padding(horizontal = 20.dp),
                            RoundedCornerShape(8.dp),
                            backgroundColor = Color.White) {
                            ConstraintLayout(modifier = Modifier.fillMaxWidth()) {

                                val (image1, Text1, image2) = createRefs()

                                Image(painter = painterResource(id = R.drawable.check),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .height(30.dp)
                                        .constrainAs(image1) {
                                            top.linkTo(parent.top)
                                            bottom.linkTo(parent.bottom)
                                            start.linkTo(parent.start, margin = 10.dp)
                                        })
                                Text(text = "${ListC[it]}",
                                    modifier = Modifier.constrainAs(Text1) {
                                        top.linkTo(parent.top)
                                        bottom.linkTo(parent.bottom)
                                        start.linkTo(parent.start, margin = 70.dp)
                                    })


                                Image(painter = painterResource(id = R.drawable.add),
                                    contentDescription = "",
                                    modifier = Modifier.constrainAs(image2) {
                                        top.linkTo(parent.top)
                                        bottom.linkTo(parent.bottom)
                                        end.linkTo(parent.end, margin = 15.dp)
                                    })
                            }
                        }
                    }
                }
            }
        }
        item {
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp), RoundedCornerShape(25.dp), backgroundColor = Color.Black) {
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {
                    Text(text = "Done",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White)
                }

            }
        }



                items(ListOfImage) { list ->
                    VerticalImage(imageModel = list)


                }
            }
        }


@Composable
fun VerticalImage(imageModel: ImageModel){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(350.dp)
        .padding(14.dp).shadow(10.dp, RectangleShape),
        RoundedCornerShape(10.dp)) {
        Image(painter = painterResource(id=imageModel.image), contentDescription = "",
            contentScale = ContentScale.FillBounds)
    }
}
@Composable
fun ProfileView(profile: Profile) {
    Column(modifier = Modifier


        .size(104.dp)) {


        Column(modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 10.dp)
            .size(64.dp)) {

            Image(painter = painterResource(id = profile.profileImage), contentDescription = "",
                modifier = Modifier.clip(CircleShape), contentScale = ContentScale.FillBounds)}
            Text(text = profile.name, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)

    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
        NewsJPCTheme {
            Home()
        }
    }