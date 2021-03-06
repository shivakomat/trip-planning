package controllers

import model.{Bucket, BucketItem, BucketItems, Buckets, FlightItem, FoodPlaceItem, PlacesToVisit, StayItem, Trip, TripPlace, TripPlaces, Trips, UserTrips, UserTripsAPI}
import JsonFormat._
import play.api.Logger
import play.api.libs.json.{JsError, Json}
import play.api.mvc._
import play.api.libs.concurrent.Execution.Implicits.defaultContext

import scala.concurrent.Future

class UserTripsController extends Controller {
  import Constants._

  val logger = Logger(this.getClass())

  def userTrip(id: Int) = Action.async {
    val userTripsAsFuture = scala.concurrent.Future{ UserTripsAPI.byUser(id) }
    userTripsAsFuture.map { userTrip => Ok(Json.toJson(userTrip)) }
  }

  def createTrip() = Action.async(BodyParsers.parse.json) { request =>
    request.body.validate[TripFormData].fold(
      errors => {
        logger.error("UserTripsController.createTrip() - ERROR LOG - " + JsError.toJson(errors))
        Future.successful(BadRequest(Json.obj("status" -> ERROR, "message" -> JsError.toJson(errors))))
      },
      trip => {
        Trips.add(trip)
        Future.successful(Ok(Json.obj("status" -> SUCCESS, "message" -> ("Trip created successfully"))))
      }
    )
  }


  def createTripPlace() = Action.async(BodyParsers.parse.json) { request =>
    request.body.validate[TripPlace].fold(
      errors => {
        logger.error("UserTripsController.createTripPlace() - ERROR LOG - " + JsError.toJson(errors))
        Future.successful(BadRequest(Json.obj("status" -> ERROR, "message" -> JsError.toJson(errors))))
      },
      tripPlace => {
        TripPlaces.add(tripPlace)
        Future.successful(Ok(Json.obj("status" -> SUCCESS, "message" -> ("A Trip Place was created successfully"))))
      }
    )
  }

  def createBucket() = Action.async(BodyParsers.parse.json) { request =>
    request.body.validate[Bucket].fold(
      errors => {
        logger.error("UserTripsController.createBucket() - ERROR LOG - " + JsError.toJson(errors))
        Future.successful(BadRequest(Json.obj("status" -> ERROR, "message" -> JsError.toJson(errors))))
      },
      bucket => {
        Buckets.add(bucket)
        Future.successful(Ok(Json.obj("status" -> SUCCESS, "message" -> ("Bucket was created successfully"))))
      }
    )
  }

  def createBucketItems() = Action.async(BodyParsers.parse.json) { request =>
    request.body.validate[BucketItem].fold(
      errors => {
        logger.error("UserTripsController.createBucketItems() - ERROR LOG - " + JsError.toJson(errors))
        Future.successful(BadRequest(Json.obj("status" -> ERROR, "message" -> JsError.toJson(errors))))
      },
      bucketItem => {
        BucketItems.add(bucketItem)
        Future.successful(Ok(Json.obj("status" -> SUCCESS, "message" -> ("Bucket item was created successfully"))))
      }
    )
  }

  def createFlightItems() = Action.async(BodyParsers.parse.json) { request =>
    request.body.validate[FlightItem].fold(
      errors => {
        logger.error("UserTripsController.createBucketItems() - ERROR LOG - " + JsError.toJson(errors))
        Future.successful(BadRequest(Json.obj("status" -> ERROR, "message" -> JsError.toJson(errors))))
      },
      flightItem => {
        BucketItems.addFlightItems(flightItem)
        Future.successful(Ok(Json.obj("status" -> SUCCESS, "message" -> ("Bucket item was created successfully"))))
      }
    )
  }

  def createFoodPlaceItems() = Action.async(BodyParsers.parse.json) { request =>
    request.body.validate[FoodPlaceItem].fold(
      errors => {
        logger.error("UserTripsController.createFoodPlaceItems() - ERROR LOG - " + JsError.toJson(errors))
        Future.successful(BadRequest(Json.obj("status" -> ERROR, "message" -> JsError.toJson(errors))))
      },
      foodPlaceItem => {
        BucketItems.addFoodPlaceItems(foodPlaceItem)
        Future.successful(Ok(Json.obj("status" -> SUCCESS, "message" -> ("Bucket item was created successfully"))))
      }
    )
  }


  def createPlacesToVisitItems() = Action.async(BodyParsers.parse.json) { request =>
    request.body.validate[PlacesToVisit].fold(
      errors => {
        logger.error("UserTripsController.createBucketItems() - ERROR LOG - " + JsError.toJson(errors))
        Future.successful(BadRequest(Json.obj("status" -> ERROR, "message" -> JsError.toJson(errors))))
      },
      placesToVisit => {
        BucketItems.addPlacesToVisitItems(placesToVisit)
        Future.successful(Ok(Json.obj("status" -> SUCCESS, "message" -> ("Bucket item was created successfully"))))
      }
    )
  }


  def createStayItems() = Action.async(BodyParsers.parse.json) { request =>
    request.body.validate[StayItem].fold(
      errors => {
        logger.error("UserTripsController.createBucketItems() - ERROR LOG - " + JsError.toJson(errors))
        Future.successful(BadRequest(Json.obj("status" -> ERROR, "message" -> JsError.toJson(errors))))
      },
      stayItem => {
        BucketItems.addStayItems(stayItem)
        Future.successful(Ok(Json.obj("status" -> SUCCESS, "message" -> ("Bucket item was created successfully"))))
      }
    )
  }

}
