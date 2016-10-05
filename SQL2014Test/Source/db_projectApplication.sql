USE [master]
GO
/****** Object:  Database [db_projectApplication]    Script Date: 12/14/2015 11:37:59 AM ******/
CREATE DATABASE [db_projectApplication]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'db_projectApplication', FILENAME = N'D:\科大学习\自学区\SQL Server 入口\2014\db_projectApplication.mdf' , SIZE = 10240KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'db_projectApplication_log', FILENAME = N'D:\科大学习\自学区\SQL Server 入口\2014\db_projectApplication_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [db_projectApplication] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [db_projectApplication].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [db_projectApplication] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [db_projectApplication] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [db_projectApplication] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [db_projectApplication] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [db_projectApplication] SET ARITHABORT OFF 
GO
ALTER DATABASE [db_projectApplication] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [db_projectApplication] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [db_projectApplication] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [db_projectApplication] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [db_projectApplication] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [db_projectApplication] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [db_projectApplication] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [db_projectApplication] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [db_projectApplication] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [db_projectApplication] SET  DISABLE_BROKER 
GO
ALTER DATABASE [db_projectApplication] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [db_projectApplication] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [db_projectApplication] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [db_projectApplication] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [db_projectApplication] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [db_projectApplication] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [db_projectApplication] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [db_projectApplication] SET RECOVERY FULL 
GO
ALTER DATABASE [db_projectApplication] SET  MULTI_USER 
GO
ALTER DATABASE [db_projectApplication] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [db_projectApplication] SET DB_CHAINING OFF 
GO
ALTER DATABASE [db_projectApplication] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [db_projectApplication] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [db_projectApplication] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'db_projectApplication', N'ON'
GO
USE [db_projectApplication]
GO
/****** Object:  User [db_projectApplicationManager]    Script Date: 12/14/2015 11:37:59 AM ******/
CREATE USER [db_projectApplicationManager] FOR LOGIN [db_projectApplication_Manager] WITH DEFAULT_SCHEMA=[db_owner]
GO
ALTER ROLE [db_owner] ADD MEMBER [db_projectApplicationManager]
GO
/****** Object:  Table [dbo].[Tb_Admit]    Script Date: 12/14/2015 11:37:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tb_Admit](
	[Admit_ID] [int] NULL,
	[Project_ID] [int] NULL,
	[Student_ID] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tb_Apply]    Script Date: 12/14/2015 11:37:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tb_Apply](
	[Apply_ID] [int] NOT NULL,
	[Project_ID] [int] NULL,
	[Student_ID] [int] NULL,
	[Apply_Rank] [int] NULL,
 CONSTRAINT [PK_Tb_Apply] PRIMARY KEY CLUSTERED 
(
	[Apply_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tb_Manager]    Script Date: 12/14/2015 11:37:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Tb_Manager](
	[Manager_ID] [int] IDENTITY(1,1) NOT NULL,
	[Manager_Username] [varchar](50) NULL,
	[Manager_Password] [varchar](50) NULL,
 CONSTRAINT [PK_Tb_Manager] PRIMARY KEY CLUSTERED 
(
	[Manager_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Tb_Project]    Script Date: 12/14/2015 11:37:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Tb_Project](
	[Project_ID] [int] IDENTITY(1,1) NOT NULL,
	[Project_Name] [varchar](50) NULL,
	[Project_Quate] [int] NULL,
	[Project_Requirement] [text] NULL,
	[Teacher_ID] [int] NOT NULL,
 CONSTRAINT [PK_Tb_Project] PRIMARY KEY CLUSTERED 
(
	[Project_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Tb_Student]    Script Date: 12/14/2015 11:37:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Tb_Student](
	[Student_ID] [int] IDENTITY(1,1) NOT NULL,
	[Student_Name] [varchar](50) NULL,
	[Student_UserName] [varchar](50) NULL,
	[Student_Password] [varchar](50) NULL,
	[Student_Gpa] [float] NULL,
	[Student_Gender] [bit] NULL,
	[Student_Grade] [int] NULL,
	[Student_Major] [varchar](50) NULL,
 CONSTRAINT [PK_Tb_Student] PRIMARY KEY CLUSTERED 
(
	[Student_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Tb_Teacher]    Script Date: 12/14/2015 11:37:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Tb_Teacher](
	[Teacher_ID] [int] IDENTITY(1,1) NOT NULL,
	[Teacher_Name] [varchar](50) NULL,
	[Teacher_UserName] [varchar](50) NULL,
	[Teacher_Password] [varchar](50) NULL,
 CONSTRAINT [PK_Tb_Teacher] PRIMARY KEY CLUSTERED 
(
	[Teacher_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_Tb_Manager]    Script Date: 12/14/2015 11:37:59 AM ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_Tb_Manager] ON [dbo].[Tb_Manager]
(
	[Manager_Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_Tb_Project]    Script Date: 12/14/2015 11:37:59 AM ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_Tb_Project] ON [dbo].[Tb_Project]
(
	[Project_Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_Tb_Student]    Script Date: 12/14/2015 11:37:59 AM ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_Tb_Student] ON [dbo].[Tb_Student]
(
	[Student_UserName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_Tb_Teacher]    Script Date: 12/14/2015 11:37:59 AM ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_Tb_Teacher] ON [dbo].[Tb_Teacher]
(
	[Teacher_UserName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Tb_Admit]  WITH CHECK ADD  CONSTRAINT [FK_Tb_Admit_Tb_Project] FOREIGN KEY([Project_ID])
REFERENCES [dbo].[Tb_Project] ([Project_ID])
GO
ALTER TABLE [dbo].[Tb_Admit] CHECK CONSTRAINT [FK_Tb_Admit_Tb_Project]
GO
ALTER TABLE [dbo].[Tb_Admit]  WITH CHECK ADD  CONSTRAINT [FK_Tb_Admit_Tb_Student] FOREIGN KEY([Student_ID])
REFERENCES [dbo].[Tb_Student] ([Student_ID])
GO
ALTER TABLE [dbo].[Tb_Admit] CHECK CONSTRAINT [FK_Tb_Admit_Tb_Student]
GO
ALTER TABLE [dbo].[Tb_Apply]  WITH CHECK ADD  CONSTRAINT [FK_Tb_Apply_Tb_Project] FOREIGN KEY([Project_ID])
REFERENCES [dbo].[Tb_Project] ([Project_ID])
GO
ALTER TABLE [dbo].[Tb_Apply] CHECK CONSTRAINT [FK_Tb_Apply_Tb_Project]
GO
ALTER TABLE [dbo].[Tb_Apply]  WITH CHECK ADD  CONSTRAINT [FK_Tb_Apply_Tb_Student] FOREIGN KEY([Student_ID])
REFERENCES [dbo].[Tb_Student] ([Student_ID])
GO
ALTER TABLE [dbo].[Tb_Apply] CHECK CONSTRAINT [FK_Tb_Apply_Tb_Student]
GO
ALTER TABLE [dbo].[Tb_Project]  WITH CHECK ADD  CONSTRAINT [FK_Tb_Project_Tb_Teacher] FOREIGN KEY([Teacher_ID])
REFERENCES [dbo].[Tb_Teacher] ([Teacher_ID])
GO
ALTER TABLE [dbo].[Tb_Project] CHECK CONSTRAINT [FK_Tb_Project_Tb_Teacher]
GO
USE [master]
GO
ALTER DATABASE [db_projectApplication] SET  READ_WRITE 
GO
