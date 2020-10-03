@startuml
left to right direction
actor "Costumer" as cst

package Aquapark {
  usecase "Recieve ID" as UC1
  usecase "Use Slide" as UC2
  usecase "Pay Reciept" as UC3
  usecase "Charged for slide" as UC4
  usecase "Give back ID" as UC5
}

actor "Aquapark" as ap

cst --> UC1
cst --> UC2
cst --> UC5
UC2 .> UC4 : include
UC5 .> UC3 : include
ap --> UC1
ap --> UC5
@enduml
